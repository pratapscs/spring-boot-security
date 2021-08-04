# spring-boot-security

- Basic Authentication
    - Basic authentification is a standard HTTP header with the user and password encoded in base64. This is one of the simplest technique 
      to protect the REST resources because it does not require cookies, session identifiers or any login pages.

    - @EnableWebSecurity
       -It allows Spring to find and automatically apply the class to the global WebSecurity.If I don't annotate any of my class with 
       @EnableWebSecurity still the application will be prompting for username and password, as this annotation takes care of enabling 
       security features at global level.

    - WebSecurityConfigurer - provides customization to the Websecurity features.

    - Cross-Site Request Forgery (CSRF) is an attack that forces an end user to execute unwanted actions on a web application in which 
      they're currently authenticated.

    - bcrypt is a hashing algorithm

    - AuthenticationEntryPoint
       -The main function of this is to allow the framework to send some sort of "to access this resource you must authenticate first" 
       notification from application server to web client.

    - BasicAuthenticationFilter in Spring is the class which is responsible for processing basic authentication credentials presented in 
      HTTP Headers and putting the result into the SecurityContextHolder, and other authentication components use the securityContextHolder 
      to authenticate or authorize accordingly.

    - BasicAuthenticationEntryPoint, LoginUrlAuthenticationEntryPoint, Http403ForbiddenEntryPoint: 
        -In case of basic authentication, the username and password is only encoded with Base64, but not encrypted or hashed in any way
          - Add another layer of authorization in method level using Roles
             - @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
             - @PreAuthorize - SPEL is supported
             - @Secured - SPEL is not supported
