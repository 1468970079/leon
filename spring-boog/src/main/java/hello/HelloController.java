package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/hello")
	public String hello(){
		logger.info("调用hello");
		String str = null;
		try {
			str.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("1000", "自定义异常", e);
		}
		return "Hello World";
	}
	
	@GetMapping("/boot")
	public String boot(String name) throws Exception{
		logger.info("调用boot,name={}", name);
		String str = null;
		try {
			name.toString();
			str = name + " Greeting from SpringBoot";
		} catch (Exception e) {
			logger.error("调用boot异常", e);
			throw e;
		}
		return str;
	}
	
}
