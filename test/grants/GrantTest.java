package grants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class GrantTest {

	@Test
	public void testCanComputeSuccessfulGrant(){
		List<Integer> values=new ArrayList<Integer>();
		values.addAll(Arrays.asList(new Integer[]{100,200,300,200}));
		Grant grant=new Grant();
		assertEquals(-1,grant.awardBudgetCutProblem(values, 800));
	}
	
	@Test
	public void testCanComputCorrectedGrant(){
		List<Integer> values=new ArrayList<Integer>();
		values.addAll(Arrays.asList(new Integer[]{100,200,300,200}));
		Grant grant=new Grant();
		assertEquals(100,grant.awardBudgetCutProblem(values, 700));
	}
	
	@Test
	public void testShouldFailIfThereIsNoBudget(){
		List<Integer> values=new ArrayList<Integer>();
		values.addAll(Arrays.asList(new Integer[]{100,200,300,200}));
		Grant grant=new Grant();
		assertEquals(0,grant.awardBudgetCutProblem(values, 0));
	}
	
	@Test
	public void testShouldAwardToAll(){
		List<Integer> values=new ArrayList<Integer>();
		values.addAll(Arrays.asList(new Integer[]{100,200,300,200}));
		Grant grant=new Grant();
		assertEquals(100,grant.awardBudgetCutProblem(values, 700));
	}
	
	@Test
	public void testAwardListContainsAllApplicants(){
		List<Integer> values=new ArrayList<Integer>();
		values.addAll(Arrays.asList(new Integer[]{100,200,300,200}));
		Grant grant=new Grant();
		Assert.assertTrue(values.containsAll(grant.getAwardList(Arrays.asList(new Integer[]{100,200,300,200}), 700)));
		
	}
}
