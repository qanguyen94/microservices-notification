package quocnguyen.demo.microservices.notification.camunda;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ExternalTaskSubscription("SendNotification") // create a subscription for this topic name
public class SendNotificationHandler implements ExternalTaskHandler {

	@SneakyThrows
	@Override
	public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

		String orderId = externalTask.getVariable("orderId");
		log.info("Start sending notification for order with id {}", orderId);

		VariableMap variables = Variables.createVariables();
		variables.put("orderId", orderId);

		// To be able to see the process running in Camunda. Let make the process stay here for a while
		Thread.sleep(5000);

		// complete the external task
		externalTaskService.complete(externalTask, variables);
		log.info("Notification for order with id {} has been sent successfully", orderId);
	}

}
