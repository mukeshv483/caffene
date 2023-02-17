package com.security.securitydemo;

import com.security.securitydemo.command.factory.Command;
import com.security.securitydemo.command.factory.CommandFactory;
import com.security.securitydemo.command.factory.OnCommand;
import com.security.securitydemo.domain.events.UserCreated;
import com.security.securitydemo.domain.events.UserRemoved;
import com.security.securitydemo.models.User;
import com.security.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import  com.security.securitydemo.models.User;
import org.springframework.scheduling.annotation.Async;

import java.util.stream.IntStream;

@SpringBootApplication(scanBasePackages = "com.security.securitydemo")
@EnableJpaRepositories
@EnableCaching
public class SecurityDemoApplication  implements CommandLineRunner {
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication springApplication =
				new SpringApplication(SecurityDemoApplication.class);
		springApplication.addListeners(new SpringBuiltInEventsListener());
		springApplication.run(args);
	}

	@EventListener(value = UserCreated.class)
	@Async
	public void listen(UserCreated user){
		System.out.println("User Created: "+user);

	}

	@EventListener(value = UserRemoved.class)
	@Async
	public void listenRemoved(UserRemoved user){
		System.out.println("User deleted: "+user);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("user lookup: ");
		String name="mukesh@mk4.com";
        IntStream.range(1,100).
				forEach(i->userRepository.findByEmail(name));
		System.out.println("user lookup:END ");
		Command onCommand=new OnCommand();
		CommandFactory factory=new CommandFactory(onCommand);
		factory.executeCommand();

		IntStream.range(1,5).forEach(i->{
		User user=User.builder().userName("create"+i).id(i).build();
			// Publishing event created by extending ApplicationEvent
			applicationEventPublisher.publishEvent(new UserCreated(user));
			// Publishing an object as an event
			user.setUserName("delete"+i);
			applicationEventPublisher.publishEvent(new UserRemoved(user));
		});
	}
}
class SpringBuiltInEventsListener
		implements ApplicationListener<SpringApplicationEvent> {

	@Override
	public void onApplicationEvent(SpringApplicationEvent event) {
		// handle event
		System.out.println("Spring events: "+event);
		System.out.println("Spring props: "+event.getSpringApplication().getAdditionalProfiles());

	}
}
