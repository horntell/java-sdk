/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horntell.model;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author sahil
 */
public class App {
    /**
     * The app's key to authenticate the API requests
     *
     * @var string
     */
    public static String key;

    /**
     * The app's secret to authenticate the API requests
     *
     * @var string
     */
    public static String secret;

    /**
     * The base URL for Horntell API
     *
     * @var string
     */
    public static String base = "https://api.horntell.com";

    /**
     * The version of API to use
     *
     * @var string
     */
    public static String version = "v1";

    /**
     * Boots the app using key and secret
     *
     * @param string $key
     * @param string $secret
     * @return void
     */
    public static void init(String key, String secret) {
        App.key = key;
        App.secret = secret;
    }

    /**
     * Returns the app's key
     *
     * @return string
     */
    public static String getKey() {
        return key;
    }

    /**
     * Returns the app's secret
     *
     * @return string
     */
    public static String getSecret() {
        return secret;
    }

    /**
     * Returns the base URL for API
     *
     * @return string
     */
    public static String getBase() {
        return base;
    }

    /**
     * Sets the base URL for the API to use
     *
     * @param string $base
     */
    public static void setBase(String base) {
        App.base = base;
    }

    /**
     * Returns the API version to use
     *
     * @return string
     */
    public static String getVersion() {
        return version;
    }

    /**
     * Sets the version of API to use
     *
     * @param string $version
     */
    public static void setVersion(String version) {
        App.version = version;
    }

    /**
     * Returns the hash_hmac value
     *
     * @return string
     */
    public static String hash(String uid) {
        try {

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            char[] hash = Hex.encodeHex(sha256_HMAC.doFinal(uid.getBytes()));
            return hash.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
