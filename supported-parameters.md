# Katalon CL Maven Plugin Parameters

## Supported Plugin Parameters

This [plugin](README.md) supports the following Maven parameters.  For information about the Katalon command line, see [Katalon Command Line options](https://docs.katalon.com/katalon-studio/docs/console-mode-execution.html#katalon-command-line-options).

* **katalonPath**. Path to the Katalon installation.  Optional if you set the KATALON_HOME environment variable.
* **katalonProjectPath**.  Required, path to your Katalon project.  *Note, the name katalonProjectPath differs from the Katalon option "projectPath" to avoid confusing the Maven and Katalong projects.*
* **testSuitePath**. Path to the test suite you want to execute, relative to the Katalon project.  One of testSuitePath or testSuiteCollectionPath is required.
* **testSuiteCollectionPath**. Path to the test suite collection you want to execute, relative to the Katalon project.  One of testSuitePath or testSuiteCollectionPath is required.
* **browserType**.  Optional, installed web browser where the tests  run.  Defaults to Chrome if not specified.  Supported types are Chrome, Chrome (headless), Firefox, IE, Safari, Remote, Android, and iOS.
* **reportFolder**.  Optional, location of .csv and .html report outputs.  May be relative to Katalon project path, or absolute path.
* **reportFileName**. Optional name of report outputs.  Use only with reportFolder parameter.
* **globals**.  Optional Global profile variables from your Katalon project that that you want to override when the tests run. Parameter is a Maven map.  *These are -g_ options to Katalon.*

## Unsupported Plugin Parameters

The Maven plugin uses the Katalon *-runMode=console* and *-noSplash* options; these are not parameters to the Maven plugin.

The plugin uses the Katalon *-consoleLog* to send output to the Maven build log.  It could be made optional in the plugin in the future.

The following Katalon options have not yet been implemented by the plugin: config, noExit, summaryReport, statusDelay, retry, retryFailedTestCases, qTestDestId, qTestDestType, sendEmail, remoteWebDriverUrl, removeWebDriverType, deviceId, email, executionProfile, or any of the proxy options. 

### See Also
[Katalon Command Line options](https://docs.katalon.com/katalon-studio/docs/console-mode-execution.html#katalon-command-line-options)