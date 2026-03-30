package com.stepdefinitions;

public class Payload {
	
	public static String CreateBooking()
	{
		String payload = "{\n"
		+ "	\"roomid\": 9,\n"
		+ "	\"firstname\": \"Veerasekaran\",\n"
		+ "	\"lastname\": \"mariappan\",\n"
		+ "	\"depositpaid\": false,\n"
		+ "	\"bookingdates\": {\n"
		+ "		\"checkin\": \"2026-03-30\",\n"
		+ "		\"checkout\": \"2026-03-31\"\n"
		+ "	},\n"
		+ "	\"email\": \"veerasekaran007@gmail.com\",\n"
		+ "	\"phone\": \"+32456789456\"\n"
		+ "}";
		return payload;
	}
		
		public static String Login()
		{
			String payload = "{\n"
					+ "    \"username\": \"admin\",\n"
					+ "    \"password\": \"password\"\n"
					+ "}";
			return payload;

}
}