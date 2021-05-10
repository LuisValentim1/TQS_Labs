Construção #2 (10/mai/2021 18:05:50) FAILED

Started by user Luís Miguel Goulart Valentim
Running as SYSTEM
Building in workspace C:\WINDOWS\system32\config\systemprofile\AppData\Local\Jenkins\.jenkins\workspace\hellogitworld
FATAL: Git repository URL 2 is an empty string in job definition. Checkout requires a valid repository URL
java.lang.IllegalArgumentException: Git repository URL 2 is an empty string in job definition. Checkout requires a valid repository URL
	at hudson.plugins.git.GitSCM.buildEnvironment(GitSCM.java:1536)
	at hudson.plugins.git.GitSCM.buildEnvVars(GitSCM.java:1481)
	at hudson.model.AbstractBuild.getEnvironment(AbstractBuild.java:950)
	at hudson.maven.AbstractMavenBuild.getEnvironment(AbstractMavenBuild.java:57)
	at hudson.maven.MavenModuleSetBuild.getEnvironment(MavenModuleSetBuild.java:168)
	at hudson.plugins.git.GitSCM.checkout(GitSCM.java:1289)
	at hudson.scm.SCM.checkout(SCM.java:505)
	at hudson.model.AbstractProject.checkout(AbstractProject.java:1204)
	at hudson.model.AbstractBuild$AbstractBuildExecution.defaultCheckout(AbstractBuild.java:636)
	at jenkins.scm.SCMCheckoutStrategy.checkout(SCMCheckoutStrategy.java:86)
	at hudson.model.AbstractBuild$AbstractBuildExecution.run(AbstractBuild.java:508)
	at hudson.model.Run.execute(Run.java:1907)
	at hudson.maven.MavenModuleSetBuild.run(MavenModuleSetBuild.java:543)
	at hudson.model.ResourceController.execute(ResourceController.java:97)
	at hudson.model.Executor.run(Executor.java:429)
Finished: FAILURE