package com.horntell;

public abstract class Horntell {
	public static final String UPLOAD_API_BASE = "https://uploads.stripe.com";
	public static final String LIVE_API_BASE = "https://api.stripe.com";
	public static final String VERSION = "1.31.0";
	public static volatile String apiKey;
	public static volatile String apiVersion;

	private static volatile String apiBase = LIVE_API_BASE;


	/**
	 * (FOR TESTING ONLY) If you'd like your API requests to hit your own
	 * (mocked) server, you can set this up here by overriding the base api URL.
	 */
	public static void overrideApiBase(final String overriddenApiBase) {
		apiBase = overriddenApiBase;
	}

	public static String getApiBase() {
		return apiBase;
	}

    static void profileGet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
