package top.fengziren.kaohexiangmu;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fengziren.modol.User;
import top.fengziren.service.UserService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Disabled
@SpringBootTest
class KaohexiangmuApplicationTests {
	@Autowired
	UserService userService;
	@Test
	public void selectUsers(){

	}

}
