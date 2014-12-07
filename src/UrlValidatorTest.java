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
import java.util.Random;

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
   public void testManualTest()
   {   
	   String thisString = "";
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.println("Expected Valid Urls (Manual Tests):");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));		//Given by instructor
	   System.out.println(String.format("%-70s", thisString = "http://www.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://amazon.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "www.hero6.org") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "hero6.org") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   /* Turns out that Apache has a separate validator for this: http://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/routines/package-summary.html#other.inet
	    * System.out.println(String.format("%-70s", thisString = "http://74.125.224.72/") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "74.125.224.72") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://[2a00:1450:8003::93]/") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   */
	   System.out.println(String.format("%-70s", thisString = "ftp://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bolo://bolo.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bitcoin://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "bitcoin1://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome-extension://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "-extension://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome-://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "chrome.extension://google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3-www.google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3_www.google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3.www.google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://ww3~www.google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google~test.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google-test.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google_test.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test~com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test-com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.test_com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.arpa") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com.us") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.state.or.us") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.state.or.us.gov") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "ftp://user:password@google.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "mailto://ketyr@onid.oregonstate.edu") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "mailto://robertkety@gmail.com") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com/%2F") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.google.com/%0D%0A") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query_string#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query_string") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://www.domain.edu:80/path?query-string#fragment_id") + "Expected: true\tActual: " + urlVal.isValid(thisString));
       
	   System.out.println("\nExpected Invalid Urls (Manual):");
	   System.out.println(String.format("%-70s", thisString = "http://www.amazon") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "!!!://www.amazon") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "httpwww.amazon.com") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "://www.amazon.com") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   System.out.println(String.format("%-70s", thisString = "http://bad!!!.gov") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   thisString = "http://www.how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   thisString = "http://www.how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters-that-did-not-seem-to-break-maybe-try-one-a-little-longer.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   thisString = "http://how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters.google.com";
	   System.out.println(String.format("%-70s", "<Too long to output>") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   thisString = "http://www.google.how-many-characters-does-it-take-to-get-to-the-center-of-a-tootsie-pop-one-two-three-four-five-six-seven-eight-nine-ten-eleven-twelve-thirteen-ugh-this-is-taking-too-long-maybe-just-ill-google-it-euerka-google-says-it-is-two-hundred-and-fifty-six-characters";
	   System.out.println(String.format("%-70s", "<Too long to output>") + "Expected: false\tActual: " + urlVal.isValid(thisString));
	   
	   //Kept this negative test on a separate line for easy copy/paste in later functions. 
	   //Additional negative tests above these lines please
	   System.out.println(String.format("%-70s", thisString = "") + "Expected: false\tActual: " + urlVal.isValid(thisString));
       
	   /* Commented out once I saw that Apache offers an IPv4 Validator: http://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/routines/package-summary.html#other.inet
       //we should test this
       System.out.println(String.format("%-70s", thisString = "257.257.258.251") + "Expected: false\tActual: " + urlVal.isValid(thisString));
       */
   }
   
   /* 
    * Partitioning ideas:
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
    * 		mailto:emailaddress@hostname			(Email)
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
    * 				www.google.com/path	(No scheme)
    * 				
    */   
   
   //Thanks to: http://en.wikipedia.org/wiki/URI_scheme
   ResultPair [] KnownValidSchemes = {
		   new ResultPair("aaa", true),
		   new ResultPair("aaas", true),
		   new ResultPair("about", true),
		   new ResultPair("acap", true),
		   new ResultPair("acct", true),
		   new ResultPair("adiumxtra", true),
		   new ResultPair("afp", true),
		   new ResultPair("afs", true),
		   new ResultPair("aim", true),
		   new ResultPair("app", true),
		   new ResultPair("apt", true),
		   new ResultPair("attachment", true),
		   new ResultPair("aw", true),
		   new ResultPair("barion", true),
		   new ResultPair("beshare", true),
		   new ResultPair("bitcoin", true),
		   new ResultPair("bolo", true),
		   new ResultPair("callto", true),
		   new ResultPair("cap", true),
		   new ResultPair("chrome", true),
		   new ResultPair("chrome", true),
		   new ResultPair("chrome-extension", true),
		   new ResultPair("cid", true),
		   new ResultPair("coap", true),
		   new ResultPair("coaps", true),
		   new ResultPair("com-eventbrite-attendee", true),
		   new ResultPair("content", true),
		   new ResultPair("crid", true),
		   new ResultPair("cvs", true),
		   new ResultPair("data", true),
		   new ResultPair("dav", true),
		   new ResultPair("dict", true),
		   new ResultPair("dlna-playsingle", true),
		   new ResultPair("dlna-playcontainer", true),
		   new ResultPair("dns", true),
		   new ResultPair("dtn", true),
		   new ResultPair("dvb", true),
		   new ResultPair("ed2k", true),
		   new ResultPair("facetime", true),
		   new ResultPair("fax", true),
		   new ResultPair("feed", true),
		   new ResultPair("file", true),
		   new ResultPair("finger", true),
		   new ResultPair("fish", true),
		   new ResultPair("ftp", true),
		   new ResultPair("geo", true),
		   new ResultPair("gg", true),
		   new ResultPair("git", true),
		   new ResultPair("gizmoproject", true),
		   new ResultPair("go", true),
		   new ResultPair("gopher", true),
		   new ResultPair("gtalk", true),
		   new ResultPair("h323", true),
		   new ResultPair("hcp", true),
		   new ResultPair("http", true),
		   new ResultPair("https", true),
		   new ResultPair("iax", true),
		   new ResultPair("icap", true),
		   new ResultPair("icon", true),
		   new ResultPair("im", true),
		   new ResultPair("imap", true),
		   new ResultPair("info", true),
		   new ResultPair("ipn", true),
		   new ResultPair("ipp", true),
		   new ResultPair("irc", true),
		   new ResultPair("irc6", true),
		   new ResultPair("ircs", true),
		   new ResultPair("iris", true),
		   new ResultPair("iris.beep", true),
		   new ResultPair("iris.xpc", true),
		   new ResultPair("iris.xpcs", true),
		   new ResultPair("iris.lws", true),
		   new ResultPair("itms", true),
		   new ResultPair("jabber", true),
		   new ResultPair("jar", true),
		   new ResultPair("jms", true),
		   new ResultPair("keyparc", true),
		   new ResultPair("lastfm", true),
		   new ResultPair("ldap", true),
		   new ResultPair("ldaps", true),
		   new ResultPair("magnet", true),
		   new ResultPair("mailserver", true),
		   new ResultPair("mailto", true),
		   new ResultPair("maps", true),
		   new ResultPair("market", true),
		   new ResultPair("message", true),
		   new ResultPair("mid", true),
		   new ResultPair("mms", true),
		   new ResultPair("modem", true),
		   new ResultPair("ms-help", true),
		   new ResultPair("ms-settings-power", true),
		   new ResultPair("msnim", true),
		   new ResultPair("msrp", true),
		   new ResultPair("msrps", true),
		   new ResultPair("mtqp", true),
		   new ResultPair("mumble", true),
		   new ResultPair("mupdate", true),
		   new ResultPair("mvn", true),
		   new ResultPair("news", true),
		   new ResultPair("nfs", true),
		   new ResultPair("ni", true),
		   new ResultPair("nih", true),
		   new ResultPair("nntp", true),
		   new ResultPair("notes", true),
		   new ResultPair("oid", true),
		   new ResultPair("opaquelocktoken", true),
		   new ResultPair("pack", true),
		   new ResultPair("palm", true),
		   new ResultPair("paparazzi", true),
		   new ResultPair("pkcs11", true),
		   new ResultPair("platform", true),
		   new ResultPair("pop", true),
		   new ResultPair("pres", true),
		   new ResultPair("prospero", true),
		   new ResultPair("proxy", true),
		   new ResultPair("psyc", true),
		   new ResultPair("query", true),
		   new ResultPair("reload", true),
		   new ResultPair("res", true),
		   new ResultPair("resource", true),
		   new ResultPair("rmi", true),
		   new ResultPair("rsync", true),
		   new ResultPair("rtmfp", true),
		   new ResultPair("rtmp", true),
		   new ResultPair("rtsp", true),
		   new ResultPair("secondlife", true),
		   new ResultPair("service", true),
		   new ResultPair("session", true),
		   new ResultPair("sftp", true),
		   new ResultPair("sgn", true),
		   new ResultPair("shttp", true),
		   new ResultPair("sieve", true),
		   new ResultPair("sip", true),
		   new ResultPair("sips", true),
		   new ResultPair("skype", true),
		   new ResultPair("smb", true),
		   new ResultPair("sms", true),
		   new ResultPair("snews", true),
		   new ResultPair("snmp", true),
		   new ResultPair("soap.beep", true),
		   new ResultPair("soap.beeps", true),
		   new ResultPair("soldat", true),
		   new ResultPair("spotify", true),
		   new ResultPair("ssh", true),
		   new ResultPair("steam", true),
		   new ResultPair("stun", true),
		   new ResultPair("stuns", true),
		   new ResultPair("svn", true),
		   new ResultPair("tag", true),
		   new ResultPair("teamspeak", true),
		   new ResultPair("tel", true),
		   new ResultPair("telnet", true),
		   new ResultPair("tftp", true),
		   new ResultPair("things", true),
		   new ResultPair("thismessage", true),
		   new ResultPair("tip", true),
		   new ResultPair("tn3270", true),
		   new ResultPair("turn", true),
		   new ResultPair("turns", true),
		   new ResultPair("tv", true),
		   new ResultPair("udp", true),
		   new ResultPair("udp", true),
		   new ResultPair("unreal", true),
		   new ResultPair("urn", true),
		   new ResultPair("ut2004", true),
		   new ResultPair("vemmi", true),
		   new ResultPair("ventrilo", true),
		   new ResultPair("videotex", true),
		   new ResultPair("view-source", true),
		   new ResultPair("wais", true),
		   new ResultPair("webcal", true),
		   new ResultPair("ws", true),
		   new ResultPair("wss", true),
		   new ResultPair("wtai", true),
		   new ResultPair("wyciwyg", true),
		   new ResultPair("xcon", true),
		   new ResultPair("xcon-userid", true),
		   new ResultPair("xfire", true),
		   new ResultPair("xmlrpc.beep", true),
		   new ResultPair("xmlrpc.beeps", true),
		   new ResultPair("xmpp", true),
		   new ResultPair("xri", true),
		   new ResultPair("ymsgr", true),
		   new ResultPair("z39.50", true),
		   new ResultPair("z39.50r", true),
		   new ResultPair("z39.50s", true),
		   new ResultPair("doi", true),
		   new ResultPair("javascript", true),
		   new ResultPair("jdbc", true),
		   new ResultPair("stratum", true)
   };
   ResultPair [] SpecificationValidSchemes = {
		   new ResultPair("www+google", true),
		   new ResultPair("w12", true),
		   new ResultPair("thisisareallylongschemethatshouldfunctionsincethereisnospecificationaboutlength", true),
		   new ResultPair("WwW", true),
		   new ResultPair("wWw", true)		   		   
   };
   ResultPair [] SpecificationInvalidSchemes = {
		   new ResultPair("www?google", false),
		   new ResultPair("w12°", false),
		   new ResultPair(":", false),
		   new ResultPair("http://www.hero6.org/\"", false),	//Most browsers will resolve this though :(
		   new ResultPair("12www", false),
		   new ResultPair("", false)
   };
   
   public void testSchemePartition()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String thisString = "";
	   boolean result = false;
	   System.out.println("\nTesting Scheme Partition:");
	   for (int n = 0; n < KnownValidSchemes.length; n++) {
		   ResultPair testPair = KnownValidSchemes[n];
		   System.out.println(String.format("%-100s", thisString = testPair.item + "://www.google.com/") + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   assertEquals(testPair.item + "://www.google.com/", testPair.valid, result);		   
	   }
	   for (int n = 0; n < SpecificationValidSchemes.length; n++) {
		   ResultPair testPair = SpecificationValidSchemes[n];
		   System.out.println(String.format("%-100s", thisString = testPair.item + "://www.google.com/") + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   assertEquals(testPair.item + "://www.google.com/", testPair.valid, result);		   
	   }
	   for (int n = 0; n < SpecificationInvalidSchemes.length; n++) {
		   ResultPair testPair = SpecificationInvalidSchemes[n];
		   System.out.println(String.format("%-100s", thisString = testPair.item + "://www.google.com/") + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   assertEquals(testPair.item + "://www.google.com/", testPair.valid, result);		   
	   }
   }
   
   //Thanks to: http://en.wikipedia.org/wiki/List_of_Internet_top-level_domains
   ResultPair [] KnownValidTLD = {
		   new ResultPair("com", true),
		   new ResultPair("edu", true),
		   new ResultPair("gov", true),
		   new ResultPair("int", true),
		   new ResultPair("mil", true),
		   new ResultPair("net", true),
		   new ResultPair("org", true),
		   new ResultPair("ac", true),
		   new ResultPair("ad", true),
		   new ResultPair("ae", true),
		   new ResultPair("af", true),
		   new ResultPair("ag", true),
		   new ResultPair("ai", true),
		   new ResultPair("al", true),
		   new ResultPair("am", true),
		   new ResultPair("an", true),
		   new ResultPair("ao", true),
		   new ResultPair("aq", true),
		   new ResultPair("ar", true),
		   new ResultPair("as", true),
		   new ResultPair("at", true),
		   new ResultPair("au", true),
		   new ResultPair("aw", true),
		   new ResultPair("ax", true),
		   new ResultPair("az", true),
		   new ResultPair("ba", true),
		   new ResultPair("bb", true),
		   new ResultPair("bd", true),
		   new ResultPair("be", true),
		   new ResultPair("bf", true),
		   new ResultPair("bg", true),
		   new ResultPair("bh", true),
		   new ResultPair("bi", true),
		   new ResultPair("bj", true),
		   new ResultPair("bm", true),
		   new ResultPair("bn", true),
		   new ResultPair("bo", true),
		   new ResultPair("bq", true),
		   new ResultPair("br", true),
		   new ResultPair("bs", true),
		   new ResultPair("bt", true),
		   new ResultPair("bv", true),
		   new ResultPair("bw", true),
		   new ResultPair("by", true),
		   new ResultPair("bz", true),
		   new ResultPair("ca", true),
		   new ResultPair("cc", true),
		   new ResultPair("cd", true),
		   new ResultPair("cf", true),
		   new ResultPair("cg", true),
		   new ResultPair("ch", true),
		   new ResultPair("ci", true),
		   new ResultPair("ck", true),
		   new ResultPair("cl", true),
		   new ResultPair("cm", true),
		   new ResultPair("cn", true),
		   new ResultPair("co", true),
		   new ResultPair("cr", true),
		   new ResultPair("cs", true),
		   new ResultPair("cu", true),
		   new ResultPair("cv", true),
		   new ResultPair("cw", true),
		   new ResultPair("cx", true),
		   new ResultPair("cy", true),
		   new ResultPair("cz", true),
		   new ResultPair("dd", true),
		   new ResultPair("de", true),
		   new ResultPair("dj", true),
		   new ResultPair("dk", true),
		   new ResultPair("dm", true),
		   new ResultPair("do", true),
		   new ResultPair("dz", true),
		   new ResultPair("ec", true),
		   new ResultPair("ee", true),
		   new ResultPair("eg", true),
		   new ResultPair("eh", true),
		   new ResultPair("er", true),
		   new ResultPair("es", true),
		   new ResultPair("et", true),
		   new ResultPair("eu", true),
		   new ResultPair("fi", true),
		   new ResultPair("fj", true),
		   new ResultPair("fk", true),
		   new ResultPair("fm", true),
		   new ResultPair("fo", true),
		   new ResultPair("fr", true),
		   new ResultPair("ga", true),
		   new ResultPair("gb", true),
		   new ResultPair("gd", true),
		   new ResultPair("ge", true),
		   new ResultPair("gf", true),
		   new ResultPair("gg", true),
		   new ResultPair("gh", true),
		   new ResultPair("gi", true),
		   new ResultPair("gl", true),
		   new ResultPair("gm", true),
		   new ResultPair("gn", true),
		   new ResultPair("gp", true),
		   new ResultPair("gq", true),
		   new ResultPair("gr", true),
		   new ResultPair("gs", true),
		   new ResultPair("gt", true),
		   new ResultPair("gu", true),
		   new ResultPair("gw", true),
		   new ResultPair("gy", true),
		   new ResultPair("hk", true),
		   new ResultPair("hm", true),
		   new ResultPair("hn", true),
		   new ResultPair("hr", true),
		   new ResultPair("ht", true),
		   new ResultPair("hu", true),
		   new ResultPair("id", true),
		   new ResultPair("ie", true),
		   new ResultPair("il", true),
		   new ResultPair("im", true),
		   new ResultPair("in", true),
		   new ResultPair("io", true),
		   new ResultPair("iq", true),
		   new ResultPair("ir", true),
		   new ResultPair("is", true),
		   new ResultPair("it", true),
		   new ResultPair("je", true),
		   new ResultPair("jm", true),
		   new ResultPair("jo", true),
		   new ResultPair("jp", true),
		   new ResultPair("ke", true),
		   new ResultPair("kg", true),
		   new ResultPair("kh", true),
		   new ResultPair("ki", true),
		   new ResultPair("km", true),
		   new ResultPair("kn", true),
		   new ResultPair("kp", true),
		   new ResultPair("kr", true),
		   new ResultPair("kw", true),
		   new ResultPair("ky", true),
		   new ResultPair("kz", true),
		   new ResultPair("la", true),
		   new ResultPair("lb", true),
		   new ResultPair("lc", true),
		   new ResultPair("li", true),
		   new ResultPair("lk", true),
		   new ResultPair("lr", true),
		   new ResultPair("ls", true),
		   new ResultPair("lt", true),
		   new ResultPair("lu", true),
		   new ResultPair("lv", true),
		   new ResultPair("ly", true),
		   new ResultPair("ma", true),
		   new ResultPair("mc", true),
		   new ResultPair("md", true),
		   new ResultPair("me", true),
		   new ResultPair("mg", true),
		   new ResultPair("mh", true),
		   new ResultPair("mk", true),
		   new ResultPair("ml", true),
		   new ResultPair("mm", true),
		   new ResultPair("mn", true),
		   new ResultPair("mo", true),
		   new ResultPair("mp", true),
		   new ResultPair("mq", true),
		   new ResultPair("mr", true),
		   new ResultPair("ms", true),
		   new ResultPair("mt", true),
		   new ResultPair("mu", true),
		   new ResultPair("mv", true),
		   new ResultPair("mw", true),
		   new ResultPair("mx", true),
		   new ResultPair("my", true),
		   new ResultPair("mz", true),
		   new ResultPair("na", true),
		   new ResultPair("nc", true),
		   new ResultPair("ne", true),
		   new ResultPair("nf", true),
		   new ResultPair("ng", true),
		   new ResultPair("ni", true),
		   new ResultPair("nl", true),
		   new ResultPair("no", true),
		   new ResultPair("np", true),
		   new ResultPair("nr", true),
		   new ResultPair("nu", true),
		   new ResultPair("nz", true),
		   new ResultPair("om", true),
		   new ResultPair("pa", true),
		   new ResultPair("pe", true),
		   new ResultPair("pf", true),
		   new ResultPair("pg", true),
		   new ResultPair("ph", true),
		   new ResultPair("pk", true),
		   new ResultPair("pl", true),
		   new ResultPair("pm", true),
		   new ResultPair("pn", true),
		   new ResultPair("pr", true),
		   new ResultPair("ps", true),
		   new ResultPair("pt", true),
		   new ResultPair("pw", true),
		   new ResultPair("py", true),
		   new ResultPair("qa", true),
		   new ResultPair("re", true),
		   new ResultPair("ro", true),
		   new ResultPair("rs", true),
		   new ResultPair("ru", true),
		   new ResultPair("rw", true),
		   new ResultPair("sa", true),
		   new ResultPair("sb", true),
		   new ResultPair("sc", true),
		   new ResultPair("sd", true),
		   new ResultPair("se", true),
		   new ResultPair("sg", true),
		   new ResultPair("sh", true),
		   new ResultPair("si", true),
		   new ResultPair("sj", true),
		   new ResultPair("sk", true),
		   new ResultPair("sl", true),
		   new ResultPair("sm", true),
		   new ResultPair("sn", true),
		   new ResultPair("so", true),
		   new ResultPair("sr", true),
		   new ResultPair("ss", true),
		   new ResultPair("st", true),
		   new ResultPair("su", true),
		   new ResultPair("sv", true),
		   new ResultPair("sx", true),
		   new ResultPair("sy", true),
		   new ResultPair("sz", true),
		   new ResultPair("tc", true),
		   new ResultPair("td", true),
		   new ResultPair("tf", true),
		   new ResultPair("tg", true),
		   new ResultPair("th", true),
		   new ResultPair("tj", true),
		   new ResultPair("tk", true),
		   new ResultPair("tl", true),
		   new ResultPair("tm", true),
		   new ResultPair("tn", true),
		   new ResultPair("to", true),
		   new ResultPair("tp", true),
		   new ResultPair("tr", true),
		   new ResultPair("tt", true),
		   new ResultPair("tv", true),
		   new ResultPair("tw", true),
		   new ResultPair("tz", true),
		   new ResultPair("ua", true),
		   new ResultPair("ug", true),
		   new ResultPair("uk", true),
		   new ResultPair("us", true),
		   new ResultPair("uy", true),
		   new ResultPair("uz", true),
		   new ResultPair("va", true),
		   new ResultPair("vc", true),
		   new ResultPair("ve", true),
		   new ResultPair("vg", true),
		   new ResultPair("vi", true),
		   new ResultPair("vn", true),
		   new ResultPair("vu", true),
		   new ResultPair("wf", true),
		   new ResultPair("ws", true),
		   new ResultPair("ye", true),
		   new ResultPair("yt", true),
		   new ResultPair("yu", true),
		   new ResultPair("za", true),
		   new ResultPair("zm", true),
		   new ResultPair("zr", true),
		   new ResultPair("zw", true),
		   new ResultPair("xn--lgbbat1ad8j", true),
		   new ResultPair("xn--y9a3aq", true),
		   new ResultPair("xn--54b7fta0cc", true),
		   new ResultPair("xn--90ais", true),
		   new ResultPair("xn--fiqs8s", true),
		   new ResultPair("xn--fiqz9s", true),
		   new ResultPair("xn--wgbh1c", true),
		   new ResultPair("xn--node", true),
		   new ResultPair("xn--j6w193g", true),
		   new ResultPair("xn--h2brj9c", true),
		   new ResultPair("xn--mgbbh1a71e", true),
		   new ResultPair("xn--fpcrj9c3d", true),
		   new ResultPair("xn--gecrj9c", true),
		   new ResultPair("xn--s9brj9c", true),
		   new ResultPair("xn--xkc2dl3a5ee0h", true),
		   new ResultPair("xn--45brj9c", true),
		   new ResultPair("xn--mgba3a4f16a", true),
		   new ResultPair("xn--mgbtx2b", true),
		   new ResultPair("xn--mgbayh7gpa", true),
		   new ResultPair("xn--80ao21a", true),
		   new ResultPair("xn--d1alf", true),
		   new ResultPair("xn--mgbx4cd0ab", true),
		   new ResultPair("xn--l1acc", true),
		   new ResultPair("xn--mgbc0a9azcg", true),
		   new ResultPair("xn--mgb9awbf", true),
		   new ResultPair("xn--mgbai9azgqp6j", true),
		   new ResultPair("xn--ygbi2ammx", true),
		   new ResultPair("xn--wgbl6a", true),
		   new ResultPair("xn--p1ai", true),
		   new ResultPair("xn--mgberp4a5d4ar", true),
		   new ResultPair("xn--90a3ac", true),
		   new ResultPair("xn--yfro4i67o", true),
		   new ResultPair("xn--clchc0ea0b2g2a9gcd", true),
		   new ResultPair("xn--3e0b707e", true),
		   new ResultPair("xn--fzc2c9e2c", true),
		   new ResultPair("xn--xkc2al3hye2a", true),
		   new ResultPair("xn--mgbpl2fh", true),
		   new ResultPair("xn--ogbpf8fl", true),
		   new ResultPair("xn--kprw13d", true),
		   new ResultPair("xn--kpry57d", true),
		   new ResultPair("xn--o3cw4h", true),
		   new ResultPair("xn--pgbs0dh", true),
		   new ResultPair("xn--j1amh", true),
		   new ResultPair("xn--mgbaam7a8h", true),
		   new ResultPair("xn--mgb2ddes", true),
		   new ResultPair("abogado", true),
		   new ResultPair("academy", true),
		   new ResultPair("accountants", true),
		   new ResultPair("active", true),
		   new ResultPair("actor", true),
		   new ResultPair("aero", true),
		   new ResultPair("agency", true),
		   new ResultPair("airforce", true),
		   new ResultPair("archi", true),
		   new ResultPair("army", true),
		   new ResultPair("associates", true),
		   new ResultPair("attorney", true),
		   new ResultPair("auction", true),
		   new ResultPair("audio", true),
		   new ResultPair("autos", true),
		   new ResultPair("band", true),
		   new ResultPair("bar", true),
		   new ResultPair("bargains", true),
		   new ResultPair("beer", true),
		   new ResultPair("best", true),
		   new ResultPair("bid", true),
		   new ResultPair("bike", true),
		   new ResultPair("bio", true),
		   new ResultPair("biz", true),
		   new ResultPair("black", true),
		   new ResultPair("blackfriday", true),
		   new ResultPair("blue", true),
		   new ResultPair("boo", true),
		   new ResultPair("boutique", true),
		   new ResultPair("build", true),
		   new ResultPair("builders", true),
		   new ResultPair("business", true),
		   new ResultPair("buzz", true),
		   new ResultPair("cab", true),
		   new ResultPair("camera", true),
		   new ResultPair("camp", true),
		   new ResultPair("cancerresearch", true),
		   new ResultPair("capital", true),
		   new ResultPair("cards", true),
		   new ResultPair("care", true),
		   new ResultPair("career", true),
		   new ResultPair("careers", true),
		   new ResultPair("casa", true),
		   new ResultPair("cash", true),
		   new ResultPair("catering", true),
		   new ResultPair("center", true),
		   new ResultPair("ceo", true),
		   new ResultPair("channel", true),
		   new ResultPair("cheap", true),
		   new ResultPair("christmas", true),
		   new ResultPair("church", true),
		   new ResultPair("city", true),
		   new ResultPair("claims", true),
		   new ResultPair("cleaning", true),
		   new ResultPair("click", true),
		   new ResultPair("clinic", true),
		   new ResultPair("clothing", true),
		   new ResultPair("club", true),
		   new ResultPair("codes", true),
		   new ResultPair("coffee", true),
		   new ResultPair("college", true),
		   new ResultPair("community", true),
		   new ResultPair("company", true),
		   new ResultPair("computer", true),
		   new ResultPair("condos", true),
		   new ResultPair("construction", true),
		   new ResultPair("consulting", true),
		   new ResultPair("contractors", true),
		   new ResultPair("cooking", true),
		   new ResultPair("cool", true),
		   new ResultPair("coop", true),
		   new ResultPair("country", true),
		   new ResultPair("credit", true),
		   new ResultPair("creditcard", true),
		   new ResultPair("cricket", true),
		   new ResultPair("cruises", true),
		   new ResultPair("dad", true),
		   new ResultPair("dance", true),
		   new ResultPair("dating", true),
		   new ResultPair("day", true),
		   new ResultPair("deals", true),
		   new ResultPair("degree", true),
		   new ResultPair("delivery", true),
		   new ResultPair("democrat", true),
		   new ResultPair("dental", true),
		   new ResultPair("dentist", true),
		   new ResultPair("desi", true),
		   new ResultPair("diamonds", true),
		   new ResultPair("diet", true),
		   new ResultPair("digital", true),
		   new ResultPair("direct", true),
		   new ResultPair("directory", true),
		   new ResultPair("discount", true),
		   new ResultPair("domains", true),
		   new ResultPair("eat", true),
		   new ResultPair("education", true),
		   new ResultPair("email", true),
		   new ResultPair("energy", true),
		   new ResultPair("engineer", true),
		   new ResultPair("engineering", true),
		   new ResultPair("enterprises", true),
		   new ResultPair("equipment", true),
		   new ResultPair("esq", true),
		   new ResultPair("estate", true),
		   new ResultPair("events", true),
		   new ResultPair("exchange", true),
		   new ResultPair("expert", true),
		   new ResultPair("exposed", true),
		   new ResultPair("fail", true),
		   new ResultPair("farm", true),
		   new ResultPair("feedback", true),
		   new ResultPair("finance", true),
		   new ResultPair("financial", true),
		   new ResultPair("fish", true),
		   new ResultPair("fishing", true),
		   new ResultPair("fitness", true),
		   new ResultPair("flights", true),
		   new ResultPair("florist", true),
		   new ResultPair("fly", true),
		   new ResultPair("foo", true),
		   new ResultPair("forsale", true),
		   new ResultPair("foundation", true),
		   new ResultPair("fund", true),
		   new ResultPair("furniture", true),
		   new ResultPair("futbol", true),
		   new ResultPair("gallery", true),
		   new ResultPair("gift", true),
		   new ResultPair("gifts", true),
		   new ResultPair("gives", true),
		   new ResultPair("glass", true),
		   new ResultPair("global", true),
		   new ResultPair("gop", true),
		   new ResultPair("graphics", true),
		   new ResultPair("gratis", true),
		   new ResultPair("green", true),
		   new ResultPair("gripe", true),
		   new ResultPair("guide", true),
		   new ResultPair("guitars", true),
		   new ResultPair("guru", true),
		   new ResultPair("haus", true),
		   new ResultPair("healthcare", true),
		   new ResultPair("help", true),
		   new ResultPair("here", true),
		   new ResultPair("hiphop", true),
		   new ResultPair("hiv", true),
		   new ResultPair("holdings", true),
		   new ResultPair("holiday", true),
		   new ResultPair("homes", true),
		   new ResultPair("horse", true),
		   new ResultPair("host", true),
		   new ResultPair("hosting", true),
		   new ResultPair("house", true),
		   new ResultPair("how", true),
		   new ResultPair("immo", true),
		   new ResultPair("immobilien", true),
		   new ResultPair("industries", true),
		   new ResultPair("info", true),
		   new ResultPair("ing", true),
		   new ResultPair("ink", true),
		   new ResultPair("institute", true),
		   new ResultPair("insure", true),
		   new ResultPair("international", true),
		   new ResultPair("investments", true),
		   new ResultPair("jetzt", true),
		   new ResultPair("jobs", true),
		   new ResultPair("juegos", true),
		   new ResultPair("kaufen", true),
		   new ResultPair("kim", true),
		   new ResultPair("kitchen", true),
		   new ResultPair("land", true),
		   new ResultPair("lawyer", true),
		   new ResultPair("lease", true),
		   new ResultPair("lgbt", true),
		   new ResultPair("life", true),
		   new ResultPair("lighting", true),
		   new ResultPair("limited", true),
		   new ResultPair("limo", true),
		   new ResultPair("link", true),
		   new ResultPair("loans", true),
		   new ResultPair("lotto", true),
		   new ResultPair("ltda", true),
		   new ResultPair("luxe", true),
		   new ResultPair("luxury", true),
		   new ResultPair("maison", true),
		   new ResultPair("management", true),
		   new ResultPair("market", true),
		   new ResultPair("marketing", true),
		   new ResultPair("media", true),
		   new ResultPair("meet", true),
		   new ResultPair("meme", true),
		   new ResultPair("menu", true),
		   new ResultPair("mobi", true),
		   new ResultPair("moda", true),
		   new ResultPair("moe", true),
		   new ResultPair("mortgage", true),
		   new ResultPair("motorcycles", true),
		   new ResultPair("mov", true),
		   new ResultPair("museum", true),
		   new ResultPair("name", true),
		   new ResultPair("navy", true),
		   new ResultPair("network", true),
		   new ResultPair("new", true),
		   new ResultPair("ngo", true),
		   new ResultPair("ninja", true),
		   new ResultPair("ong", true),
		   new ResultPair("onl", true),
		   new ResultPair("ooo", true),
		   new ResultPair("organic", true),
		   new ResultPair("partners", true),
		   new ResultPair("parts", true),
		   new ResultPair("photo", true),
		   new ResultPair("photography", true),
		   new ResultPair("photos", true),
		   new ResultPair("physio", true),
		   new ResultPair("pics", true),
		   new ResultPair("pictures", true),
		   new ResultPair("pink", true),
		   new ResultPair("pizza", true),
		   new ResultPair("place", true),
		   new ResultPair("plumbing", true),
		   new ResultPair("post", true),
		   new ResultPair("press", true),
		   new ResultPair("pro", true),
		   new ResultPair("productions", true),
		   new ResultPair("properties", true),
		   new ResultPair("property", true),
		   new ResultPair("pub", true),
		   new ResultPair("realtor", true),
		   new ResultPair("recipes", true),
		   new ResultPair("red", true),
		   new ResultPair("reise", true),
		   new ResultPair("reisen", true),
		   new ResultPair("ren", true),
		   new ResultPair("rentals", true),
		   new ResultPair("repair", true),
		   new ResultPair("report", true),
		   new ResultPair("republican", true),
		   new ResultPair("rest", true),
		   new ResultPair("restaurant", true),
		   new ResultPair("reviews", true),
		   new ResultPair("rich", true),
		   new ResultPair("rocks", true),
		   new ResultPair("rodeo", true),
		   new ResultPair("sarl", true),
		   new ResultPair("schule", true),
		   new ResultPair("services", true),
		   new ResultPair("sexy", true),
		   new ResultPair("shiksha", true),
		   new ResultPair("shoes", true),
		   new ResultPair("singles", true),
		   new ResultPair("social", true),
		   new ResultPair("solar", true),
		   new ResultPair("solutions", true),
		   new ResultPair("soy", true),
		   new ResultPair("space", true),
		   new ResultPair("supplies", true),
		   new ResultPair("supply", true),
		   new ResultPair("support", true),
		   new ResultPair("surf", true),
		   new ResultPair("surgery", true),
		   new ResultPair("systems", true),
		   new ResultPair("tattoo", true),
		   new ResultPair("tax", true),
		   new ResultPair("technology", true),
		   new ResultPair("tel", true),
		   new ResultPair("tienda", true),
		   new ResultPair("tips", true),
		   new ResultPair("today", true),
		   new ResultPair("tools", true),
		   new ResultPair("top", true),
		   new ResultPair("town", true),
		   new ResultPair("toys", true),
		   new ResultPair("trade", true),
		   new ResultPair("training", true),
		   new ResultPair("travel", true),
		   new ResultPair("university", true),
		   new ResultPair("uno", true),
		   new ResultPair("vacations", true),
		   new ResultPair("ventures", true),
		   new ResultPair("versicherung", true),
		   new ResultPair("vet", true),
		   new ResultPair("viajes", true),
		   new ResultPair("villas", true),
		   new ResultPair("vision", true),
		   new ResultPair("vodka", true),
		   new ResultPair("voting", true),
		   new ResultPair("voyage", true),
		   new ResultPair("wang", true),
		   new ResultPair("watch", true),
		   new ResultPair("webcam", true),
		   new ResultPair("website", true),
		   new ResultPair("wed", true),
		   new ResultPair("wiki", true),
		   new ResultPair("works", true),
		   new ResultPair("world", true),
		   new ResultPair("wtf", true),
		   new ResultPair("xxx", true),
		   new ResultPair("xyz", true),
		   new ResultPair("zone", true),
		   new ResultPair("xn--ngbc5azd", true),
		   new ResultPair("xn--mgbab2bd", true),
		   new ResultPair("xn--q9jyb4c", true),
		   new ResultPair("xn--3ds443g", true),
		   new ResultPair("xn--fiq228c5hs", true),
		   new ResultPair("xn--6frz82g", true),
		   new ResultPair("xn--ses554g", true),
		   new ResultPair("xn--io0a7i", true),
		   new ResultPair("xn--55qx5d", true),
		   new ResultPair("xn--czru2d", true),
		   new ResultPair("xn--nqv7f", true),
		   new ResultPair("xn--6qq986b3xl", true),
		   new ResultPair("xn--czr694b", true),
		   new ResultPair("xn--rhqv96g", true),
		   new ResultPair("xn--d1acj3b", true),
		   new ResultPair("xn--80asehdb", true),
		   new ResultPair("xn--c1avg", true),
		   new ResultPair("xn--80aswg", true),
		   new ResultPair("xn--i1b6b1a6a2e", true),
		   new ResultPair("alsace", true),
		   new ResultPair("asia", true),
		   new ResultPair("bayern", true),
		   new ResultPair("berlin", true),
		   new ResultPair("brussels", true),
		   new ResultPair("budapest", true),
		   new ResultPair("bzh", true),
		   new ResultPair("capetown", true),
		   new ResultPair("cat", true),
		   new ResultPair("cologne", true),
		   new ResultPair("cymru", true),
		   new ResultPair("durban", true),
		   new ResultPair("eus", true),
		   new ResultPair("frl", true),
		   new ResultPair("gal", true),
		   new ResultPair("gent", true),
		   new ResultPair("hamburg", true),
		   new ResultPair("joburg", true),
		   new ResultPair("kiwi", true),
		   new ResultPair("koeln", true),
		   new ResultPair("krd", true),
		   new ResultPair("london", true),
		   new ResultPair("madrid", true),
		   new ResultPair("melbourne", true),
		   new ResultPair("miami", true),
		   new ResultPair("moscow", true),
		   new ResultPair("nagoya", true),
		   new ResultPair("nrw", true),
		   new ResultPair("nyc", true),
		   new ResultPair("okinawa", true),
		   new ResultPair("paris", true),
		   new ResultPair("quebec", true),
		   new ResultPair("ruhr", true),
		   new ResultPair("saarland", true),
		   new ResultPair("scot", true),
		   new ResultPair("taipei", true),
		   new ResultPair("tatar", true),
		   new ResultPair("tirol", true),
		   new ResultPair("tokyo", true),
		   new ResultPair("vegas", true),
		   new ResultPair("vlaanderen", true),
		   new ResultPair("wales", true),
		   new ResultPair("wien", true),
		   new ResultPair("yokohama", true),
		   new ResultPair("xn--80adxhks", true),
		   new ResultPair("allfinanz", true),
		   new ResultPair("android", true),
		   new ResultPair("axa", true),
		   new ResultPair("bloomberg", true),
		   new ResultPair("bmw", true),
		   new ResultPair("bnpparibas", true),
		   new ResultPair("cal", true),
		   new ResultPair("caravan", true),
		   new ResultPair("cern", true),
		   new ResultPair("chrome", true),
		   new ResultPair("citic", true),
		   new ResultPair("crs", true),
		   new ResultPair("cuisinella", true),
		   new ResultPair("dnp", true),
		   new ResultPair("dvag", true),
		   new ResultPair("emerck", true),
		   new ResultPair("firmdale", true),
		   new ResultPair("flsmidth", true),
		   new ResultPair("frogans", true),
		   new ResultPair("gbiz", true),
		   new ResultPair("gle", true),
		   new ResultPair("globo", true),
		   new ResultPair("gmail", true),
		   new ResultPair("gmo", true),
		   new ResultPair("gmx", true),
		   new ResultPair("google", true),
		   new ResultPair("ibm", true),
		   new ResultPair("kred", true),
		   new ResultPair("lacaixa", true),
		   new ResultPair("lds", true),
		   new ResultPair("mango", true),
		   new ResultPair("mini", true),
		   new ResultPair("monash", true),
		   new ResultPair("mormon", true),
		   new ResultPair("neustar", true),
		   new ResultPair("nexus", true),
		   new ResultPair("nhk", true),
		   new ResultPair("nra", true),
		   new ResultPair("otsuka", true),
		   new ResultPair("ovh", true),
		   new ResultPair("sca", true),
		   new ResultPair("scb", true),
		   new ResultPair("tui", true),
		   new ResultPair("yandex", true),
		   new ResultPair("xn--qcka1pmc", true),
		   new ResultPair("xn--flw351e", true),
		   new ResultPair("xn--cg4bki", true),
		   new ResultPair("xn--fiq64b", true),
		   new ResultPair("xn--kgbechtv", true),
		   new ResultPair("xn--hgbk6aj7f53bba", true),
		   new ResultPair("xn--0zwm56d", true),
		   new ResultPair("xn--g6w251d", true),
		   new ResultPair("xn--80akhbyknj4f", true),
		   new ResultPair("xn--11b5bs3a9aj6g", true),
		   new ResultPair("xn--jxalpdlp", true),
		   new ResultPair("xn--9t4b11yi5a", true),
		   new ResultPair("xn--deba0ad", true),
		   new ResultPair("xn--zckzah", true),
		   new ResultPair("xn--hlcj6aya9esc7a", true)
   };
   ResultPair [] SpecificationValidTLD = {
		   new ResultPair("hero6", true),
		   new ResultPair("COM", true),
		   new ResultPair("a123", true),
		   new ResultPair("dash-com", true),
		   new ResultPair("123", true)
   };
   ResultPair [] SpecificationInvalidTLD = {
		   new ResultPair("WereKnightsoftheRoundTableWedancewhenerewereableWedoroutinesandchorusscenesWithfootworkimpeccableWedinewellhereinCamelotWeeathamandjamandspamalotWereKnightsoftheRoundTableOurshowareformidableButmanytimesweregivenrhymesThatarequiteunsingableWereOperamadinCamelotWesingfromthediaphragmaloooooootInwarweretoughandableQuiteindefatigableBetweenourquestswesequinvestsAndimpersonateClarkGableItsabusylifeinCamelotIhavetopushthepramalot", false),
		   new ResultPair("bad!", false),
		   new ResultPair("123", false)
   };
   
   public void testTopLevelDomainPartition(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String thisString = "";
	   boolean result = false;
	   System.out.println("\nTesting Top-level Domain Partition:");
	   for (int n = 0; n < KnownValidTLD.length; n++) {
		   ResultPair testPair = KnownValidTLD[n];
		   System.out.println(String.format("%-100s", thisString = "http://www.google." + testPair.item) + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   //assertEquals("http://www.google." + testPair.item, testPair.valid, result);
	   }
	   for (int n = 0; n < SpecificationValidTLD.length; n++) {
		   ResultPair testPair = SpecificationValidTLD[n];
		   System.out.println(String.format("%-100s", thisString = "http://www.google." + testPair.item) + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   //assertEquals("http://www.google." + testPair.item, testPair.valid, result);		   
	   }
	   for (int n = 0; n < SpecificationInvalidTLD.length; n++) {
		   ResultPair testPair = SpecificationInvalidTLD[n];
		   System.out.println(String.format("%-100s", thisString = "http://www.google." + testPair.item) + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
		   assertEquals("http://www.google." + testPair.item, testPair.valid, result);		   
	   }
   }
   
   ResultPair [] SpecificationValidSubdomain = {
		   new ResultPair("a", true),
		   new ResultPair("1", true),
		   new ResultPair("ab", true),
		   new ResultPair("a1", true),
		   new ResultPair("abc", true),
		   new ResultPair("ab1", true),
		   new ResultPair("abc-123", true),
		   new ResultPair("123-abc", true),
		   new ResultPair("12", true),
		   new ResultPair("123", true),
		   new ResultPair("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-0123456789", true)  //63 characters are the max valid
   };
   ResultPair [] SpecificationInvalidSubdomain = {
		   new ResultPair("", false),
		   new ResultPair("-a", false),
		   new ResultPair("a-", false),
		   new ResultPair("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-0123456789ThisOneIsWaaaaaayTooLong", false),
		   new ResultPair("|—V√L!–", false),
		   new ResultPair("no spaces", false),
		   new ResultPair("../", false)
   };
 
   public void SubDomainPartitionUnitTest(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String thisString = "";
	   boolean result = false;
	   //int randomGen = new Random().nextInt(SpecificationInvalidSubdomain.length);
	   int maxNumLabels = 10;
	   String subdomain = "";
	   String hostname = "";
	   String validTLD = "com";
	   boolean validity = false;
       String invalidsubdomain = "";
       String url = "";
       int[][] arrayOfBadTests = new int[65536][7];
       int arrayCounter = 0;
	   System.out.println("\nTesting Subdomain Partition:");
	   ResultPair [] AllSubdomains = new ResultPair[SpecificationValidSubdomain.length + SpecificationInvalidSubdomain.length]; 
	   System.arraycopy(SpecificationValidSubdomain, 0, AllSubdomains, 0, SpecificationValidSubdomain.length);
	   System.arraycopy(SpecificationInvalidSubdomain, 0, AllSubdomains, SpecificationValidSubdomain.length, SpecificationInvalidSubdomain.length);
	   
	   System.out.println("\n1 to 5 level Subdomain Partition (Output of test failures only):");
	   
	   for (int k = 0; k < AllSubdomains.length; k++) {
		   for (int m = -1; m < AllSubdomains.length; m++) {
			   for (int n = -1; n < AllSubdomains.length; n++) {
				   for (int p = -1; p < AllSubdomains.length; p++) {
					   for (int q = -1; q < AllSubdomains.length; q++) { 
						   ResultPair testPair1 = AllSubdomains[k];				   
						   ResultPair testPair2 = (m == -1) ? new ResultPair("", true) : AllSubdomains[m];
						   ResultPair testPair3 = (n == -1) ? new ResultPair("", true) : AllSubdomains[n];
						   ResultPair testPair4 = (p == -1) ? new ResultPair("", true) : AllSubdomains[p];
						   ResultPair testPair5 = (q == -1) ? new ResultPair("", true) : AllSubdomains[q];
						   
						   hostname = testPair1.item;
						   hostname += (m == -1) ? "" : "." + testPair2.item;
						   hostname += (n == -1) ? "" : "." + testPair3.item;
						   hostname += (p == -1) ? "" : "." + testPair4.item;
						   hostname += (q == -1) ? "" : "." + testPair5.item;
						   hostname += "." + validTLD;
								   
						   validity = testPair1.valid && testPair2.valid && testPair3.valid && testPair4.valid && testPair5.valid;
						   
						   if(hostname.length() > 253)
							   validity = false;
						   
						   url = "http://" + hostname + "/";
						   if((validity != (result = urlVal.isValid(url))) && (arrayCounter < 65536)){
							   arrayOfBadTests[arrayCounter][0] = k;
							   arrayOfBadTests[arrayCounter][1] = m;
							   arrayOfBadTests[arrayCounter][2] = n;
							   arrayOfBadTests[arrayCounter][3] = p;
							   arrayOfBadTests[arrayCounter][4] = q;
							   arrayOfBadTests[arrayCounter][5] = validity ? 1 : 0;
							   arrayOfBadTests[arrayCounter][6] = result ? 1 : 0;
							   
							   arrayCounter += 1;
						   }						   
						   //System.out.println(String.format("%-70s", String.format("Alldomain elements: [%d].[%d].[%d].[%d].[%d]", k, m, n, p, q)) + "\t\tExpected: " + validity + "\t\tActual: " + (result = urlVal.isValid(url)));
						   //System.out.println(((hostname.length() > 261) ? String.format("%-262s", "<Output too long>") : String.format("%-262s", url)) + "Expected: " + validity + "\tActual: " + (result = urlVal.isValid(url)));
				           //assertEquals(url, validity, result);
					   }
				   }
			   }
		   }
	   }
	    
	   for(int k = 0; k < arrayCounter; k++){
		   url = "http://";
		   url += AllSubdomains[arrayOfBadTests[k][0]].item;
		   url += (arrayOfBadTests[k][1] == -1) ? "" : "." + AllSubdomains[arrayOfBadTests[k][1]].item;
		   url += (arrayOfBadTests[k][2] == -1) ? "" : "." + AllSubdomains[arrayOfBadTests[k][2]].item;
		   url += (arrayOfBadTests[k][3] == -1) ? "" : "." + AllSubdomains[arrayOfBadTests[k][3]].item;
		   url += (arrayOfBadTests[k][4] == -1) ? "" : "." + AllSubdomains[arrayOfBadTests[k][4]].item;
		   url += "/";

		   validity = (arrayOfBadTests[k][5] != 0) ? true : false;
		   result = (arrayOfBadTests[k][6] != 0) ? true : false;
		   
		   System.out.println(((hostname.length() > 261) ? String.format("%-262s", "<Output too long>") : String.format("%-262s", url)) + "Expected: " + validity + "\t\tActual: " + result);
	   }
	   
	   /*for (int k = 1; k < maxNumLabels; k++) {
		   for(int m = 0; m < k; m++){
			   for (int n = 0; n < SpecificationValidSubdomain.length; n++) {
				   ResultPair testPair = SpecificationValidSubdomain[n];
				   subdomain += testPair.item + ".";
                   
                   System.out.println(String.format("%-70s", thisString = "http://" + subdomain + "google.com") + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
                   //assertEquals("http://" + subdomain + "google.com", testPair.valid, result);
			   }
		   }
	   }
       
       for (int k = 1; k < maxNumLabels; k++) {
           for(int m = 0; m < k; m++){
               for (int n = 0; n < SpecificationInvalidSubdomain.length; n++) {
                   ResultPair testPair = SpecificationInvalidSubdomain[n];
                   invalidsubdomain += testPair.item + ".";
                   
                   System.out.println(String.format("%-70s", thisString = "http://" + invalidsubdomain + "google.com") + "Expected: " + testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
                   assertEquals("http://" + invalidsubdomain + "google.com", testPair.valid, result);
               }
           }
       }*/
    }
    
   // "The first question mark is used as a separator and is not part of the query string" - http://en.wikipedia.org/wiki/Query_string
   ResultPair[] SpecificationQueryStrings = {
	    new ResultPair("title=Main&action=raw", true),
	    new ResultPair("title=Main", true),
	    new ResultPair("first=this+is+a+field&second=was+it+clear+%28already%29%3F", true),  //http://en.wikipedia.org/wiki/Query_string
	    new ResultPair("first=under_score", true),
	    new ResultPair("second=dash-dash", true),
	    new ResultPair("third=dots.dots", true),
	    new ResultPair("fourth=asterick*asterick", true),
	    new ResultPair("fifth=tilde~tilde", true),  //Permitted by RFC3986
	    new ResultPair("", true)
	};
	ResultPair[] SpecificationInvalidQueryStrings = {
	    new ResultPair("bad=@!%$% &%^&(*^&*(", false),
	    new ResultPair("bad2= ", false),	    
	};
   
    public void testQueryStrings()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String thisString = "";
        boolean result = false;
        
        System.out.println("Query Partition:");
        
        for (int n = 0; n < SpecificationQueryStrings.length; n++) {
            ResultPair testPair = SpecificationQueryStrings[n];
            System.out.println(String.format("%-100s", thisString = "http://www.google.com/path?" + testPair.item) + "Expected: "+ testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
            //assertEquals("http://www.google.com/" + testPair.item, testPair.valid, result);
        }
        
        for (int n = 0; n < SpecificationInvalidQueryStrings.length; n++) {
            ResultPair testPair = SpecificationInvalidQueryStrings[n];
            System.out.println(String.format("%-100s", thisString = "http://www.google.com/path?" + testPair.item) + "Expected: "+ testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
            //assertEquals("http://www.google.com/" + testPair.item, testPair.valid, result);
        }
    }
    
    ResultPair[] SpecificationInvalidPortNumbers = {
        new ResultPair("ada", false),
        new ResultPair("-1234", false)
    };
    
    public void testPortNumbers()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String thisString = "";
        boolean result = false;
        
        System.out.println("Port Number Partition:");
        
        //Known valid port numbers from http://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers#Well-known_ports
        for (int n = 0; n < 61002; n++) {
            ResultPair testPair = new ResultPair(new Integer(n).toString(), true);
            System.out.println(String.format("%-100s", thisString = "http://www.google.com:" + testPair.item) + "Expected: "+ testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
            //assertEquals("http://www.google.com" + testPair.item, testPair.valid, result);
        }
        for (int n = 0; n < SpecificationInvalidPortNumbers.length; n++) {
            ResultPair testPair = SpecificationInvalidPortNumbers[n];
            System.out.println(String.format("%-100s", thisString = "http://www.google.com:" + testPair.item) + "Expected: "+ testPair.valid + "\tActual: " + (result = urlVal.isValid(thisString)));
            //assertEquals("http://www.google.com" + testPair.item, testPair.valid, result);
        }
    }

    /*
    * We have a solid breakdown of partitioning. It shouldn't be too hard to create our own version of the combination technique used
    * in the code from part A. We shouldn't copy the code, but formalizing our partitions, adding an array of possible values (positive
    * and negative test cases) for each subsection of the url, and then testing all combinations would be a great programming based test.
    * He actually suggests this approach in the project guidelines, but emphasizes that we should develop our own logic.
    *  
    */
    
    /* This function passes good an bad components to the URL Validator to confirm that it distinguishes between good and bad URLs. It is most
     * useful as a unit or regression test as its input domain is limited.  */
   public void testIntegrityCheck()
   {   
	   Random randomGen = new Random();
       boolean result = true;
       boolean expect = true;
       int randomNum, pos1,pos2,pos3,pos4,pos5;
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       
       //strings array to choose from
       String schemestring[] = {"http://", "ftp://", "h3t://"};
       String badschemestring [] = {"http!://", "http;://", "http:://"};
       
       String authritystring[] = {"www.cheese.com",  "pepperoni.com", "www.test.us.com"};
       String badauthritystring [] = {"25.100.123.134", ".olive.", ""};
       
       String portstring[] = {":1234", ":567", ":89"};
       String badportstring[] = {":cheese",":0pepperoi0", ":-01143"};
       
       String pathstring[] = {"/cheese", "/pepperoi", "/black/olive"};
       String badpathstring [] = {"/cheese//", "/|peperroi", "//black olive"};
       
       String querystring[] = {"?cheese=100", "?pepperoni=pizza&speggetti", "?pizza=black+olive"};
       String badquerystring [] = {"?@*#^*!()","?!@#!@asd+qwe","?[asd#$@]"};
       
       //these are the strings
       String scheme = "";
       String authrity = "";
       String port = "";
       String path = "";
       String query = "";
       
       System.out.println("\nTesting isvalid():");
       for(int i = 0; i < 100; i++)
       {
           //generate random numbers
           //randomNum = randomGen.nextInt();
           
           //generate random between 0-2 to choose the string
           pos1 = randomGen.nextInt(3);
           pos2 = randomGen.nextInt(3);
           pos3 = randomGen.nextInt(3);
           pos4 = randomGen.nextInt(3);
           pos5 = randomGen.nextInt(3);
           
           //We will randomly pass in valid or invalid parts,
           //if its divisible by 2 it expected result should be true
           if( (new Random(i*i).nextInt() % 20) < 10){
               scheme = schemestring[pos1];
               authrity = authritystring[pos2];
               port = portstring[pos3];
               path = pathstring[pos4];
               query = querystring[pos5];
               expect = (expect && true);
           }
           else{
               scheme = badschemestring[pos1];
               authrity = badauthritystring[pos2];
               port = badportstring[pos3];
               path = badpathstring[pos4];
               query = badquerystring[pos5];
               expect = (expect && false);
           }
           
           
           //If the result isn't as expected it will print out an error message.
           result = urlVal.isValid(schemestring[pos1] + authritystring[pos2] + portstring[pos3] + pathstring[pos4] + query);
           System.out.println(String.format("%-100s", schemestring[pos1] + authritystring[pos2] + portstring[pos3] + pathstring[pos4] + query) + "\tReturn: " + result + "\tExpected: " + expect);
           if(result != expect){
        	   System.out.println("\tFound an error: expected results for QUERY does not match");
           }
           
           //testing Path in isValid
           result = urlVal.isValid(schemestring[pos1] + authritystring[pos2] + portstring[pos3] + path + querystring[pos5]);
           System.out.println(String.format("%-100s", schemestring[pos1] + authritystring[pos2] + portstring[pos3] + path + querystring[pos5]) + "\tReturn: " + result + "\tExpected: " + expect);
           if(result != expect){
        	   System.out.println("\tFound an error: expected results for PATH does not match");
           }
           
           //testing Port in isValid
           result = urlVal.isValid(schemestring[pos1] + authritystring[pos2] + port + pathstring[pos4] + querystring[pos5]);
           System.out.println(String.format("%-100s", schemestring[pos1] + authritystring[pos2] + port + pathstring[pos4] + querystring[pos5]) + "\tReturn: " + result + "\tExpected: " + expect);
           if(result != expect){
        	   System.out.println("\tFound an error: expected results for PORT does not match");
           }
           
           //testing Path in isValid
           result = urlVal.isValid(schemestring[pos1] + authrity + portstring[pos3] + pathstring[pos4] + querystring[pos5]);
           System.out.println(String.format("%-100s", schemestring[pos1] + authrity + portstring[pos3] + pathstring[pos4] + querystring[pos5]) + "\tReturn: " + result + "\tExpected: " + expect);
           if(result != expect){
        	   System.out.println("\tFound an error: expected results for PATH does not match");
           }
           
           //testing Scheme in isValid
           result = urlVal.isValid(scheme + authritystring[pos2] + portstring[pos3] + pathstring[pos4] + querystring[pos5]);
           System.out.println(String.format("%-100s", scheme + authritystring[pos2] + portstring[pos3] + pathstring[pos4] + querystring[pos5]) + "\tReturn: " + result + "\tExpected: " + expect);
           if(result != expect){
        	   System.out.println("\tFound an error: expected results for AUTHERITY does not match");
           }

       
       }
       
       System.out.println("Unit Test Complete\n");
   }
   
   public void testKnownValidURLCombinationUnitTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String thisString = "";
       boolean result = false;
       boolean expect = true;
       System.out.println("\nUnit test:");
       
       //all valid schemes combined with all valid TLDs:
       for (int i = 0; i < KnownValidSchemes.length; i++) {
          for (int j = 0; j < KnownValidTLD.length; j++) {
               for (int l = 0; l < 61002; l++) {
                   for (int n = 0; n < SpecificationQueryStrings.length; n++) {
                	   ResultPair schemePair = KnownValidSchemes[i];
                	   ResultPair tldPair = KnownValidTLD[j];
                	   ResultPair portPair = new ResultPair(new Integer(l).toString(), true);
                	   ResultPair queryPair = SpecificationQueryStrings[n];
                       
                	   thisString = schemePair.item;
                	   thisString += "://www.google.";
                       thisString += tldPair.item;
                       thisString += ":";
                       thisString += portPair.item;
                       thisString += "/path/?";                       
                       thisString += queryPair.item;
                       
                       if(!(result = urlVal.isValid(thisString)))
                    	   System.out.println(String.format("%-100s", thisString) + "Expected: true\tActual: " + result);
                       //assertEquals(thisString, true, result);
                   }
               }
          }
      }
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
