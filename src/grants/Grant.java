package grants;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grant {

	static final String AMOUNT_UNAWARDED = "grant_unawarded";
	static final String GRANTS_COUNT = "grant_count";
	static final String NEW_GRANTS = "new_grants";
	static final String CAP = "cap";

	public Map<String, Integer> calculateGrant(List<Integer> values, int limit) {
		Map<String, Integer> totalGrants = new HashMap<String, Integer>();
		int total = 0;
		int count = 0;
		int grantUnAwarded = -1;
		for (int grant : values) {
			if ((total + grant) > limit) {
				grantUnAwarded = (limit - total);
				break;
			}
			total += grant;
			count++;
		}
		totalGrants.put(AMOUNT_UNAWARDED, grantUnAwarded);
		totalGrants.put(GRANTS_COUNT, count);
		return totalGrants;
	}

	public Map<String, Object> correctedAwards(List<Integer> grants, int budget) {
		List<Integer> newGrants = new ArrayList<Integer>();
		Map<String, Integer> totalGrants = calculateGrant(grants, budget);
		int amountUnawarded = totalGrants.get(AMOUNT_UNAWARDED);
		int grantsAwarded = totalGrants.get(GRANTS_COUNT);
		// the balance will be shared by the remaini awardees
		int unawardedApplicants = grants.size() - grantsAwarded;
		int balance = 0;
		if (unawardedApplicants > 0) {
			balance = amountUnawarded / unawardedApplicants;
		}
		newGrants.addAll(grants.subList(0, grantsAwarded));
		for (int i = 0; i < grantsAwarded; i++) {
			System.out.println(grants.get(i));
		}
		// the remainder is split
		for (int i = 0; i < grants.size() - grantsAwarded; i++) {
			newGrants.add(balance);
			System.out.println(balance);
		}
		Map<String, Object> grantsMap = new HashMap<>();
		grantsMap.put(CAP, balance);
		grantsMap.put(NEW_GRANTS, newGrants);
		return grantsMap;
	}

	public int awardBudgetCutProblem(List<Integer> grants, int budget) {
		int award = 0;
		if (budget > 0) {
			award = (int) correctedAwards(grants, budget).get(CAP);
		}else{
			return 0;
		}
		return award != 0 ? award : -1;
	}

	public List<Integer> getAwardList(List<Integer> grants, int budget) {
		return (List<Integer>) correctedAwards(grants, budget).get(NEW_GRANTS);
	}
}
