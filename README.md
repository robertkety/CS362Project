CS362Project
============

CS362 Course Project - URL Validator

This is the correct version of URLValidator. We will be working on UrlValidatorTest.class, but load the project in Eclipse by selecting File, New, Java Project, name it, select the location of your git directory, and click finish.

Project Instructions follow:

You are provided a buggy version of URLValidator. You need to find out as much bugs as you can in this bad URLValidator. In the last assignment I have provided the current test framework that apache commons team had to test URLValidator. We need to assume that all those tests don’t exist. Your team is a testing company and client comes to you with URLValidator implementation and ask for your help to make it bug free. You need to just concentrate on valid() method, the one that is tested in testIsValid() method of last assignment. Your task is to find out all the bugs, find out failure causes and provide bug reports. Though for this project, as long as you find out three bugs that should be sufficient. You don’t need to fix any of the bugs. Developers will do it.  Bug reports will contain 

  1. What is the failure?
  2. How did you find it?
  3. What is the cause of that failure? Explain what part of code is causing it?

You can use any methodology that your learn during the class to test it. To stay consistent let us do it this way.

        First just do manual testing. Call the valid method of URLValidator with different possible valid/invalid inputs and see if you find a failure. (2 points)

        Second, come up with good input partitioning. Try to provide a varying set of inputs that partition the overall input set well. Did you find any failures? You can call valid method once or more for each partition. (3 points)

        Third, do programming based testing. Write few unit test cases. You can have some sort of loop in your unit test and test different url with each instance of loop. Something very similar to testIsValid() but your own logic and idea. Even a single test will be sufficient if you write it like testIsValid() method. Did you find any failures? Submit your test files and test cases as part of your work under your onid/URLValidator folder.   (5 points)

    When you find out any failure, debug using Eclipse debugger and try to localize its cause.    Provide at what line/lines in what file the failure manifested itself. Did you use any of Agan’s principle in debugging URLValidator?  (5 points)

    Provide a report called URLValidator.pdf/URLValidator.txt (5 points). You need to provide following details in the report. Clearly mention your methodology of testing. For manual testing, provide some of your (not all) urls. For partitioning, mention your partitions with reasons. For unit tests/random tests, submit your unit tests using svn under URLValidator folder. In report files mention the name of your tests. Also mention, how did you work in the team? How did you divide your work? How did you collaborate? Write bug report for each of the bugs you found. Bug report should follow all the standard bug reporting principle, Use apache commons validator issue tracking system issues as standard to write bug report. Please mention in the bug report, file name and line number where bug manifested itself. Provide your debugging details for each bugs. You don't need to report bugs using svn, just dump your bug report in the URLValidator.pdf/.txt file. 

    I know that we have not studied and understood the URL Validator code like dominion code. For this particular part of the project, I want you to go through all the standard practices that we went through during the class and apply it to a real world project. Most of the bugs are very superficial and you should be able to find it. I will post a video on 8th week that will walk through the URL Validator more and explain you what is expected. Applying all the principles correctly and document them properly in URLVaidator.txt is most important.
