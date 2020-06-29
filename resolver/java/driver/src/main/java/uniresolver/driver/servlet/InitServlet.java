package uniresolver.driver.servlet;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uniresolver.driver.Driver;

public class InitServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3165107149874392145L;

	private static final Logger log = LoggerFactory.getLogger(InitServlet.class);

	private static Driver driver = null;

	public InitServlet() {

		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		if (driver == null) {

			String driverClassName = config.getInitParameter("Driver");
			Class<? extends Driver> driverClass;

			try {

				driverClass = driverClassName == null ? null : (Class<? extends Driver>) Class.forName(driverClassName);
				driver = driverClass == null ? null : driverClass.getDeclaredConstructor().newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
					| InvocationTargetException ex) {

				throw new ServletException(ex.getMessage(), ex);
			}

			if (driver == null)
				throw new ServletException("Unable to load driver: " + driverClassName);

			if (log.isInfoEnabled())
				log.info("Loaded driver: " + driverClass);
		}
	}

	static Driver getDriver() {

		return driver;
	}
}
