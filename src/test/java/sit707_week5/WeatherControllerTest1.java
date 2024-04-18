package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest1 {

	private static WeatherController wController;
    private static double[] hourlyTemperatures;

    @BeforeClass
    public static void setUp() {
        // Initialize controller only once
        wController = WeatherController.getInstance();

        // Retrieve all hourly temperatures and store them locally
        int nHours = wController.getTotalHours();
        hourlyTemperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        // Close the controller after all tests are done
        wController.close();
    }
    
	@Test
	public void testStudentIdentity() {
		String studentId = "s223021831";
		Assert.assertNotNull("Student ID is :", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "N G H Madushani";
		Assert.assertNotNull("Student name is :", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

        double minTemperature = Double.MAX_VALUE;
        for (double temperatureVal : hourlyTemperatures) {
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

        double maxTemperature = -1;
        for (double temperatureVal : hourlyTemperatures) {
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

        double sumTemp = 0;
        for (double temperatureVal : hourlyTemperatures) {
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / hourlyTemperatures.length;

        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
