package org.sebsy.demo.escaperooms;

import org.junit.jupiter.api.Test;
import org.sebsy.demo.escaperooms.bll.Room1Service;
import org.sebsy.demo.escaperooms.bll.RoomService;
import org.sebsy.demo.escaperooms.bll.Treasure2Service;
import org.sebsy.demo.escaperooms.bll.TreasureService;
import org.sebsy.demo.escaperooms.controller.EscapeRoom1Controller;
import org.sebsy.demo.escaperooms.controller.EscapeRoom2Controller;
import org.sebsy.demo.escaperooms.controller.TreasureRoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EscapeRoomsApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private RoomService roomService;

	@Autowired
	private TreasureService treasureService;

	@Test
	void contextLoads() {
	}

	@Test
	void escapeRoom1ControllerBeanIsLoaded() {
		assertThat(context.getBean(EscapeRoom1Controller.class)).isNotNull();
	}

	@Test
	void room2BeanExistsAndIsEscapeRoom2Controller() {
		Object room2 = context.getBean("room2");
		assertThat(room2).isInstanceOf(EscapeRoom2Controller.class);
	}

	@Test
	void treasureRoomControllerBeanIsLoaded() {
		assertThat(context.getBean(TreasureRoomController.class)).isNotNull();
	}

	@Test
	void roomServiceIsRoom1Service() {
		assertThat(roomService).isInstanceOf(Room1Service.class);
	}

	@Test
	void treasureServiceIsTreasure2Service() {
		assertThat(treasureService).isInstanceOf(Treasure2Service.class);
	}

	@Test
	void room1ServiceEntreeSalleReturnsExpectedMessage() {
		assertThat(roomService.entreeSalle())
				.isEqualTo("Bravo, vous avez trouvé la deuxième salle !");
	}

	@Test
	void treasure2ServiceOuvrirReturnsExpectedMessage() {
		assertThat(treasureService.ouvrir())
				.isEqualTo("Gagné, vous avez trouvé la salle du trésor !");
	}

}