# CI-web Project

Features:
- Declarative security for web apps
- Simple form based login to protect the app contents
- Database access using JPA
- JSF views
- Unit test
- Disabled but present Selenium test via code and recorded test

The project consists of the following artifacts:
- ci-web.war: Web frontend

# Running
1. `mvn package`
1. Start Glassfish 4 server `$GLASSFISH_HOME/bin/asadmin start-domain`
1. Start Derby `$GLASSFISH_HOME/bin/asadmin start-database`
1. Open Glassfish Administration Console to configure the realm: <a href="http://localhost:4848">http://localhost:4848</a>
   1. From the Administration Console, expand the Configurations node, then expand the server-config node.
   2. Expand the Security node.
   3. Expand the Realms node.
   4. Select the File node.
   5. On the Edit Realm page, click Manage Users.
   6. On the File Users page, click New.
   7. In the User ID field, enter a user ID.
   8. In the Group List field, enter SomeUser.
   9. In the New Password and Confirm New Password fields, enter a password.
   10. Click OK.
1. Set up Default Principal to Role Mapping in GlassFish Server.
   1. From the Administration Console, expand the Configurations node, then expand the server-config node.
   2. Select the Security node.
   3. Select the Default Principal to Role Mapping Enabled check box.
   4. Click Save.
1. Deploy the `ci-first.war` using the Glash Administration Console.
1. Navigate to <a href="http://localhost:8080/ci-web/">http://localhost:8080/ci-web/</a>
1. Exit embedded glashfish by entering `x ENTER`, or press just `ENTER` to redeploy.

# Manually running the Selenium test
1. `mvn -Pselenium-with-ci-glassfish verify`

# Windows note
On Windows use %GLASSFISH_HOME% or replace it with your installation
path of the Glassfish server. Replace `/` with `\` and `:` with `;`.

# Out of memory
It may happen depending on your environment. Optionally increase memory available to maven (JDK6 syntax):
* OSX/Linux `export MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`
* Windows `set MAVEN_OPTS="-Xmx=1024m -XX:MaxPermSize=1024m"`

EOF
