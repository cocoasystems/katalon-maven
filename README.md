# Katalon Command Line Maven Plugin

Executes Katalon Studio automated tests from your Maven build.

## Getting Started

### Maven POM
Add a build step to your Maven pom.xml file.

```
	<build>
		<plugins>
			<plugin>
				<groupId>com.cocoasystems</groupId>
				<artifactId>katalon-cl-maven-plugin</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<configuration>
					<katalonProjectPath>${project.baseDir}\Sample Katalon Project</katalonProjectPath>
					<testSuitePath>Test Suites/My Test Suite</testSuitePath>
				</configuration>
				<executions>
					<execution>
						<phase>install</phase>
						<goals>
							<goal>exec-katalon</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

### Command Line

To execute Katalon using this POM from the command line use

```
mvn katalon-cl:exec-katalon
```

To execute a different test suite use

```
mvn katalon-cl:exec-katalon -testSuitePath="Test Suites/Another Suite"
```

The plugin uses the KATALON_HOME environment variable to find where you installed/unzipped Katalon Studio.  If you do not want to set KATALON_HOME, or want to override this value, use the katalonPath parameter.

More information coming soon on other parameter options. 

## Authors

* **Harold Owen** - *Initial work* - Cocoasystems Inc.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* The Katalon Studio Development Team and Lounge
* The test automators.  (They knew who they are.)


