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
	   String thisString = "";
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.println("Expected Valid Urls:");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon.com") + urlVal.isValid(thisString));		//Given by instructor
	   System.out.println(String.format("%-70s", thisString = "http://www.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "www.hero6.org") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "hero6.org") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "24.20.29.121") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://[2a00:1450:4007:80b::1008]/") + urlVal.isValid(thisString));
	   
	   System.out.println("\nExpected Invalid Urls:");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "httpwww.amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "://www.amazon.com") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http") + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://") + urlVal.isValid(thisString));
	   
	   System.out.println(String.format("%-70s", thisString = "") + urlVal.isValid(thisString));
   }
   
   
   public void testYourFirstPartition()
   {
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
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
