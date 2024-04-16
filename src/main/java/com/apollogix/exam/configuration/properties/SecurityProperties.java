package com.apollogix.exam.configuration.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Security properties
 */
@ConfigurationProperties("common.security")
public class SecurityProperties {

    @JsonProperty("cors")
    private Cors cors;

    @JsonProperty("path-matcher")
    private PathMatcherConfig pathMatcher;

    /**
     * @return {@link #cors}
     */
    public Cors getCors() {
        return cors;
    }

    /**
     * @param cors {@link Cors}
     */
    public void setCors(Cors cors) {
        this.cors = cors;
    }

    /**
     * @return {@link #pathMatcher}
     */
    public PathMatcherConfig getPathMatcher() {
        return pathMatcher;
    }

    /**
     * @param pathMatcher {@link PathMatcherConfig}
     */
    public void setPathMatcher(PathMatcherConfig pathMatcher) {
        this.pathMatcher = pathMatcher;
    }


    /**
     * PathMatcher properties
     */
    public static class PathMatcherConfig {
        @JsonProperty("permit-all-path-patterns")
        private Set<String> permitAllPathPatterns = null;

        @JsonProperty("permit-all-path-pattern-with-role")
        private Map<String, PathPatternRoles> permitAllPathPatternsWithRole;

        /**
         * @return {@link #permitAllPathPatterns}
         */
        public Set<String> getPermitAllPathPatterns() {
            return permitAllPathPatterns;
        }

        public Map<String, PathPatternRoles> getPermitAllPathPatternsWithRole() {
            return permitAllPathPatternsWithRole;
        }

        /**
         * @param permitAllPathPatterns permitAllPathPatterns
         */
        public void setPermitAllPathPatterns(Set<String> permitAllPathPatterns) {
            this.permitAllPathPatterns = permitAllPathPatterns;
        }
    }

    public static class PathPatternRoles {
        @JsonProperty("pattern")
        private String pattern;

        @JsonProperty("role")
        private String role;

        public String getRole() {
            return role;
        }

        public String getPattern() {
            return pattern;
        }
    }

    /**
     * Cors properties
     */
    public static class Cors {
        @JsonProperty("allowed-origins")
        private List<String> allowedOrigins;

        @JsonProperty("allowed-methods")
        private List<String> allowedMethods;

        @JsonProperty("allowed-headers")
        private List<String> allowedHeaders;

        /**
         * @return {@link #allowedOrigins}
         */
        public List<String> getAllowedOrigins() {
            return allowedOrigins;
        }

        /**
         * @param allowedOrigins allowedOrigins
         */
        public void setAllowedOrigins(List<String> allowedOrigins) {
            this.allowedOrigins = allowedOrigins;
        }

        /**
         * @return {@link #allowedMethods}
         */
        public List<String> getAllowedMethods() {
            return allowedMethods;
        }

        /**
         * @param allowedMethods allowedMethods
         */
        public void setAllowedMethods(List<String> allowedMethods) {
            this.allowedMethods = allowedMethods;
        }

        /**
         * @return {@link #allowedHeaders}
         */
        public List<String> getAllowedHeaders() {
            return allowedHeaders;
        }

        /**
         * @param allowedHeaders setAllowedHeaders
         */
        public void setAllowedHeaders(List<String> allowedHeaders) {
            this.allowedHeaders = allowedHeaders;
        }

        @Override
        public String toString() {
            return "Cors{" +
                    "allowedOrigins=" + allowedOrigins +
                    ", allowedMethods=" + allowedMethods +
                    ", allowedHeaders=" + allowedHeaders +
                    '}';
        }
    }
}
