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
					<projectPath>${project.basedir}/MyKatalonProject</projectPath>
					<testSuitePath>Test Suites/MyTestSuite</testSuitePath>
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

To execute Katalon from the command line use

```
mvn katalon-cl:exec-katalon -DprojectPath="C:/MyKatalonProject" -testSuitePath="Test Suites/MyTestSuite"
```


## Authors

* **Harold Owen** - *Initial work* - Cocoasystems Inc.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* The Katalon Studio Development Team
* The test automators.  (They knew who they are.)


