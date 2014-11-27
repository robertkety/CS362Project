/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   //private boolean printStatus = false;
   //private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   /*
	    * My method here does not follow a proper test plan.  We didn't appear to focus on test plans, which are a 
	    * priority for proper testing. A good test plan would steer manual testing in a proper direction. What we
	    * have here is just one persons attempt to out-think the implementation.  I researched a lot of the w3 
	    * standards to produce my tests, but all of this simply adds up to aiding our partitioning effort in part
	    * two.
	    * If you'd like to visit some of my research links:
	    * http://en.wikipedia.org/wiki/Uniform_resource_locator
	    * http://en.wikipedia.org/wiki/List_of_Internet_top-level_domains
	    * http://en.wikipedia.org/wiki/URI_scheme
	    * http://www.w3.org/Addressing/URL/url-spec.html
	    * http://www.w3.org/Addressing/URL/uri-spec.html	//Not a duplicate, this focuses on urI not urL
	    * http://www.boutell.com/newfaq/creating/domainlength.html
	    * http://www.dwheeler.com/essays/debugging-agans.html //Not related here, but we'll need it to answer one of the later questions
	    * 
	    */
	   
	   String thisString = "";
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.println("Expected Valid Urls:");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon.com") + urlVal.isValid(thisString));		//Given by instructor
	   System.out.println(String.format("%-70s", thisString = "http://www.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "www.hero6.org") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "hero6.org") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://74.125.224.72/") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "74.125.224.72") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://[2a00:1450:8003::93]/") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "ftp://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bolo://bolo.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bitcoin://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bitcoin1://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome-extension://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "-extension://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome-://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome.extension://google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3-www.google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3_www.google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3.www.google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3~www.google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google~test.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google-test.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google_test.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test~com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test-com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test_com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.arpa") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com.us") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.state.or.us") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.state.or.us.gov") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "ftp://user:password@google.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "mailto://ketyr@onid.oregonstate.edu") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "mailto://robertkety@gmail.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com/%2F") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com/%0D%0A") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query_string#fragment_id") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query_string") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path#fragment_id") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query-string#fragment_id") + urlVal.isValid(thisString));
	   
	   System.out.println("\nExpected Invalid Urls:");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "!!!://www.amazon") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "httpwww.amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "://www.amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://bad!!!.gov") + urlVal.isValid(thisString));
	   thisString = "http://how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + urlVal.isValid(thisString));
	   thisString = "http://how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters-that-did-not-seem-to-break-maybe-try-one-a-little-longer.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + urlVal.isValid(thisString));
	   thisString = "http://how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters.google.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + urlVal.isValid(thisString));
	   thisString = "http://www.google.how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters";
	   System.out.println(String.format("%-70s", "<Too long to output>") + urlVal.isValid(thisString));
	   
	   //Kept this negative test on a separate line for easy copy/paste in later functions. 
	   //Additional negative tests above these lines please
	   System.out.println(String.format("%-70s", thisString = "") + urlVal.isValid(thisString));
	   
   }
   
   
   public void testYourFirstPartition()
   {
	   /* 
	    * Partitioning ideas:
	    * ipv4
	    * ipv6
	    * url:  - The primary partition, we can probably lump together the ipvX tests into a separate partition
	    * 	According to http://en.wikipedia.org/wiki/Uniform_resource_locator the full url format is:
	    * 		scheme://domain:port/path?query_string#fragment_id
	    * 	However, I have seen alternative schemes at http://www.w3.org/Addressing/URL/url-spec.html#z49
	    * 
	    * 	I say we break this into simple, extended, and advanced partitions
	    * 	Simple: 
	    * 		scheme://domain/path
	    * 	Extended:
	    * 		scheme://domain:port/path?query_string#fragment_id
	    * 	Advanced:
	    * 		IPV4:
	    * 			scheme://255.255.255.255:port/path?query_string#fragment_id
	    * 		IPV6:
	    *			scheme://[2a00:1450:8003::93]:port/path?query_string#fragment_id
	    *		mailto:emailaddress@hostname			(Email)
	    *		ftp://username:password@domain			(Login credentials)
	    *		http://xn--sterreich-z7a.icom.museum/	(Internationalized web addresses)
	    * 
	    * 	Each of these partitions will overlap with the follow universal domain boundaries:
	    * 		Unreserved characters:	http://en.wikipedia.org/wiki/Uniform_resource_locator#Unreserved
	    * 		Reserved characters: http://en.wikipedia.org/wiki/Uniform_resource_locator#Reserved  //This will be negative cases unless we encode them (see http://en.wikipedia.org/wiki/Percent-encoding)
	    * 		Minimum and maximum field limits: I found one mention of maximum at:  http://www.boutell.com/newfaq/creating/domainlength.html
	    * 		Domain name variations: There are many variations around. Most of us are familiar with TLDs (See http://en.wikipedia.org/wiki/List_of_Internet_top-level_domains) 
	    * 			For example: 
	    * 				www.state.or.us
	    * 				http://www.vmr.gov.ua/
	    * 		Null/Empty-string Permutations: We need to test when certain components are no added (e.g., missing path, missing scheme, etc)
	    * 			For example:
	    * 				http://google.com	(No subdomain, no path)
	    * 				sftp://192.168.1.1 	(No port, no path)
	    * 				www.google.com/path	(No scheme)
	    * 				
	    */		
	    			
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   /*
	    * We have a solid breakdown of partitioning. It shouldn't be too hard to create our own version of the combination technique used
	    * in the code from part A. We shouldn't copy the code, but formalizing our partitions, adding an array of possible values (positive
	    * and negative test cases) for each subsection of the url, and then testing all combinations would be a great programming based test.
	    * He actually suggests this approach in the project guidelines, but emphasizes that we should develop our own logic.
	    *  
	    */
	   
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
