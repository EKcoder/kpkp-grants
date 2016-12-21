package grants;

import java.util.List;

public class GrantUtil {

	public static boolean grantsCountIsValid(List<Integer> grants,int minGrants,int maxGrants){
		if(minGrants!=0){
			if(grants.size()<minGrants){
				return false;
			}
		}
		if(maxGrants!=0){
			if(grants.size()>maxGrants){
				return false;
			}
		}
		return true;
		
	}
	
	public static boolean grantsAmountIsCorrect(List<Integer> grants,int grantNo,int minAmount){
		if(grantNo!=-1&&minAmount!=-1){
			return grants.get(grantNo)>=minAmount;
		}
		return true;
	}
}
