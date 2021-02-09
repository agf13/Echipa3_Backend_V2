package com.echipa3.backend.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String ANNOUNCEMENTS_URL = "/announcements**";
    public static final String CONTESTS_URL = "/contests**";
    public static final String COURSES_URL = "/courses**";
    public static final String INTERNSHIPS_URL = "/internships**";
    public static final String JOBS_URL = "/jobs**";
    public static final String OTHERS_URL = "/others**";
    public static final String COMPANIES_URL = "/companies**";
}
