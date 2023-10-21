package part1;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArtist {

	@Test
	public void testAddArtist_testCase1() {
		//Test Case 1: Test Case 1 Check the function with valid inputs
		//Test Case 1_Test Data 1

		Artist artistTestCase1Data1 = new Artist("569MMMRR_%","Ari","Carlton|Melbourne|Victoria","28-10-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","blues")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase1Data1.addArtist();
		assertEquals(true,x); 
		
		//Test Case 1_Test Data 2
		Artist artistTestCase1Data2 = new Artist("569ZZMRR_%","Deepthi","Syndey|NSW|Australia","30-04-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase1Data2.addArtist();
		assertEquals(true,y);
		
	}
	
	
	@Test
	public void testAddArtist_testCase2() {
		//Test Case 2: Check the function with invalid ID inputs
		//Test Case 2_Test Data 1

		Artist artistTestCase2Data1 = new Artist("123%","Ari","Carlton|Melbourne|Victoria","28-10-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","blues")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase2Data1.addArtist();
		assertEquals(false,x); 
		
		//Test Case 2_Test Data 2
		Artist artistTestCase2Data2 = new Artist("569ZZMRR5","Deepthi","Syndey|NSW|Australia","30-04-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase2Data2.addArtist();
		assertEquals(false,y);
		
	}
	@Test
	public void testAddArtist_testCase3() {
		//Test Case 3: Check the function with invalid birth date inputs
		//Test Case 3_Test Data 1

		Artist artistTestCase3Data1 = new Artist("569MMMRR_%","Ari","Carlton|Melbourne|Victoria","28-Oct-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","blues")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase3Data1.addArtist();
		assertEquals(false,x); 
		
		//Test Case 3_Test Data 2
		Artist artistTestCase3Data2 = new Artist("569ZZMRR_%","Deepthi","Syndey|NSW|Australia","30-Apr-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase3Data2.addArtist();
		assertEquals(false,y);
		
	}
	@Test
	public void testAddArtist_testCase4() {
		//Test Case 4: Check the function with invalid address inputs
		//Test Case 4_Test Data 1

		Artist artistTestCase4Data1 = new Artist("569MMMRR_%","Ari","Carlton|Melbourne","28-10-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","blues")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase4Data1.addArtist();
		assertEquals(false,x); 
		
		//Test Case 4_Test Data 2
		Artist artistTestCase4Data2 = new Artist("569ZZMRR_%","Deepthi","Carlton|Melbourne|VIC|Australia","30-04-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase4Data2.addArtist();
		assertEquals(false,y);
		
	}
	@Test
	public void testAddArtist_testCase5() {
		//Test Case 5: Check the function with invalid occupations inputs
		//Test Case 5_Test Data 1

		Artist artistTestCase5Data1 = new Artist("569MMMRR_%","Ari","Carlton|Melbourne|Victoria","28-10-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer","director","lyricist","actor","producer")),new ArrayList<>(Arrays.asList("pop","blues")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase5Data1.addArtist();
		assertEquals(false,x); 
		
		//Test Case 1_Test Data 2
		Artist artistTestCase5Data2 = new Artist("569ZZMRR_%","Deepthi","Syndey|NSW|Australia","30-04-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList()),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase5Data2.addArtist();
		assertEquals(false,y);
	}
		
	
	
	@Test
	public void testAddArtist_testCase6() {
		//Test Case 6: Check the function with invalid genre inputs
		//Test Case 6_Test Data 1

		Artist artistTestCase6Data1 = new Artist("569MMMRR_%","Ari","Carlton|Melbourne|Victoria","28-10-1998", "Ari is an alternative rock artist based in Melbourne she loves rock music.",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","rock")),new ArrayList<>(Arrays.asList("2022, Best Song Written For Visual Media")));
		boolean x= artistTestCase6Data1.addArtist();
		assertEquals(false,x); 
		
		//Test Case 6_Test Data 2
		Artist artistTestCase6Data2 = new Artist("569ZZMRR_%","Deepthi","Syndey|NSW|Australia","30-04-2008", "Deepthi is an Indie rock artist from India, she has won many awards.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistTestCase6Data2.addArtist();
		assertEquals(false,y);
	}
	// TEST CASES FOR updateArtist()
	
	@Test
	public void testUpdateArtist_testCase1() {
		//Test Case 1: Check the function with valid inputs
		
		//Adding artist to update
		Artist artistUpdTestCase1Data1 = new Artist("589ZZMRR_%","John","Syndey|NSW|Australia","30-04-1978", "John is a very good guitarist and has a large fan following.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		boolean y= artistUpdTestCase1Data1.addArtist();
		assertEquals(true,y);
		//Test Case 1_Test Data 1
		boolean x= artistUpdTestCase1Data1.updateArtist("589ZZMRR_%","Johnny","Sydney|NSW|Australia","30-04-1978", "John is a very good guitarist and has a large fan following.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie","alt rock","RAP")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		assertEquals(true,x); 
		//Test Case 1_Test Data 2
		boolean z= artistUpdTestCase1Data1.updateArtist("589ZZMRR_%","Johnny","Melbourne|VIC|Australia","30-04-1978", "John is a very good guitarist and has a large fan following.",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("indie", "alt rock")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song")));
		assertEquals(true,z); 
		
		
	} 
	
	@Test
	public void testUpdateArtist_testCase2() {
		//Test Case 2: Check the function with invalid bio
		
		//Adding artist that is to be updated
		Artist artistUpdTestCase2Data1 = new Artist("699MMMRR_%","Neethi","Thivim|Goa|India","01-01-1989", "Neethi is an upcoming rap artist based in India. She is a rising star",new ArrayList<>(Arrays.asList("singer","rapper")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song Ever")));
		boolean w=artistUpdTestCase2Data1.addArtist();
		assertEquals(true,w); 
		
		//Test Case 2_Test Data 1
		boolean x= artistUpdTestCase2Data1.updateArtist("699MMMRR_%","Neethi","Thivim|Goa|India","01-01-1989", "Neethi is an artist.",new ArrayList<>(Arrays.asList("singer","rapper")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song")));
		assertEquals(false,x); 
		
		//Test Case 2_Test Data 2
		boolean y= artistUpdTestCase2Data1.updateArtist("699MMMRR_%","Neethi","Thivim|Goa|India","01-01-1989", "Neethi is an upcoming rap artist based in India. She has won many awards, she has been singing rap music since she was 12 years old she is also a very famous magician and dancer",new ArrayList<>(Arrays.asList("singer","rapper")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song")));
		assertEquals(false,y); 				
	} 
	
	@Test
	public void testUpdateArtist_testCase3() {
		//Test Case 3: Check the function with invalid awards inputs
		
		//adding artist to update
		Artist artistUpdTestCase3Data1 = new Artist("699MMMPP_%","Arpit","Bengaluru|Karnataka|India","24-03-1998", "Arpit is an established pop artist based in India. He is amazing at what he does",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song Ever")));
		boolean w=artistUpdTestCase3Data1.addArtist();
		assertEquals(true,w); 
		
		//Test Case 3_Test Data 1
		boolean x= artistUpdTestCase3Data1.updateArtist("699MMMPP_%","Arpit","Bengaluru|Karnataka|India","24-03-1998", "Arpit is an established pop artist based in India. He is amazing at what he does",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song","2020, VTV Award")));
		assertEquals(false,x); 
		
		//Test Case 3_Test Data 2
		boolean y= artistUpdTestCase3Data1.updateArtist("699MMMPP_%","Arpit","Bengaluru|Karnataka|India","24-03-1998", "Neethi is an upcoming rap artist based in India. She has won many awards, she has been singing rap music since she was 12 years old she is also a very famous magician and dancer",new ArrayList<>(Arrays.asList("singer","rapper")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Indie Song", "2020, MTV Best Pop Song", "2021, VTV Best Indie Song", "2019, Paris Best Indie Song", "2017, India Best Indie Song")));
		assertEquals(false,y); 				
	} 
	
	@Test
	public void testUpdateArtist_testCase4() {
		//Test Case 4: Check the function with invalid occupation inputs
		
		//adding artist to update
		Artist artistUpdTestCase4Data1 = new Artist("999MMMPP_%","Nidhi","Quebec|Montreal|Canada","27-11-1998", "Nidhi is an established rock artist based in Canada. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song Ever")));
		boolean w=artistUpdTestCase4Data1.addArtist();
		assertEquals(true,w); 
		
		//Test Case 4_Test Data 1
		boolean x= artistUpdTestCase4Data1.updateArtist("999MMMPP_%","Nidhi","Quebec|Montreal|Canada","27-11-1998", "Nidhi is an established rock artist based in Canada. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer","writer","dancer")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song","2020, VTV Award")));
		assertEquals(false,x); 
		
		//Test Case 4_Test Data 2
		boolean y= artistUpdTestCase4Data1.updateArtist("999MMMPP_%","Nidhi","Quebec|Montreal|Canada","27-11-1998", "Nidhi is an established rock artist based in Canada. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer")),new ArrayList<>(Arrays.asList("rap")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song","2020, VTV Award")));
		assertEquals(false,y); 				
	} 
	
	@Test
	public void testUpdateArtist_testCase5() {
		//Test Case 5: Check the function with invalid addresss
		//adding artist to test update on
		Artist artistUpdTestCase5Data1 = new Artist("999ZZZPP_%","April","Fitzroy|Melbourne|Australia","28-12-1990", "April was born and raised in Fitzroy, she is now an emerging pop artist who has been nominated for 4 grammy awards",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","soul")),new ArrayList<>(Arrays.asList("2006, MTV Best Soul Song")));
		boolean w=artistUpdTestCase5Data1.addArtist();
		assertEquals(true,w); 
		
		
		//Test Case 5_Test Data 1
		boolean x= artistUpdTestCase5Data1.updateArtist("999ZZZPP_%","April","Fitzroy|Melbourne","28-12-1990", "April was born and raised in Fitzroy, she is now an emerging pop artist who has been nominated for 4 grammy awards",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","soul")),new ArrayList<>(Arrays.asList("2006, MTV Best Soul Song ")));
		assertEquals(false,x); 
		//Test Case 5_Test Data 2
		boolean y= artistUpdTestCase5Data1.updateArtist("999ZZZPP_%","April","Australia","28-12-1990", "April was born and raised in Fitzroy, she is now an emerging pop artist who has been nominated for 4 grammy awards",new ArrayList<>(Arrays.asList("singer","writer")),new ArrayList<>(Arrays.asList("pop","soul")),new ArrayList<>(Arrays.asList("2006, MTV Best Soul Song ")));
		assertEquals(false,y); 				
	} 
	
	@Test
	public void testUpdateArtist_testCase6() {
		//Test Case 6: Check the function with invalid awards
		//adding artist to update 
		Artist cartistUpdTestCase2Data1 = new Artist("999QQQPP_%","Rash","Bristol|England|UK","11-11-1978", "Rash is an established soul artist based in UK. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2023, MTV Best Rap Song Ever", "1998, Grammy Best Soul Song")));
		boolean w=cartistUpdTestCase2Data1.addArtist();
		assertEquals(true,w); 
		
		//Test Case 6_Test Data 1
		boolean x= cartistUpdTestCase2Data1.updateArtist("999QQQPP_%","Rash","Bristol|England|UK","11-11-1978", "Nidhi is an established soul artist based in UK. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer","dancer")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2020, VTV Award for Best Soul Song")));
		assertEquals(false,x); 
		//Test Case 6_Test Data 2
		boolean y= cartistUpdTestCase2Data1.updateArtist("999QQQPP_%","Rash","Bristol|England|UK","27-11-1978", "Nidhi is an established soul artist based in UK. She is amazing at what she does",new ArrayList<>(Arrays.asList("singer", "dancer")),new ArrayList<>(Arrays.asList("rap","soul")),new ArrayList<>(Arrays.asList("2021, MTV Best Rap Song","2020, VTV Award for best Soul Music")));
		assertEquals(false,y);			
	} 
	
	
}