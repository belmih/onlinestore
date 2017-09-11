package ru.belmih.webstore.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.objenesis.strategy.InstantiatorStrategy;

/**
 * Handles requests for the application home page.
 */
@Repository
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	HomeController(DataSource dataSource){
		logger.info("In HomeController(DataSource dataSource)");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome1 home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String base() {
		logger.info("In base();");
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
		logger.info(Integer.toString(rowCount));
		//jdbcTemplate.execute("CREATE TABLE customers1(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
		return "base";
	}
	
	
	
}
