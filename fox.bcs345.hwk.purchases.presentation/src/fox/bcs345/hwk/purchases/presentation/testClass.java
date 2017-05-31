package fox.bcs345.hwk.purchases.presentation;

public class testClass {

	
	public enum statusCode{
		SUCCESS,FAILURE
		
	}




	
	public statusCode checkNumber(String number, String addressNumber ){
		
		if(number == addressNumber){
			
			return statusCode.SUCCESS;
		}else{
		
		return statusCode.FAILURE;
	}

	}//end of checkNumber	
		
		public statusCode checkStreet(String street, String addressStreet){
	
		if(street == addressStreet){
			
			return statusCode.SUCCESS;
		}else{
		
		return statusCode.FAILURE;
	}

		
	}//end of checkStreet
		
		
		public statusCode checkCity(String city, String addressCity){
			
			if(city == addressCity){
				
				return statusCode.SUCCESS;
			}else{
			
			return statusCode.FAILURE;
		}
	
		}// end of checkCity
		
		
		public statusCode checkState(String state, String addressState){
			
			if(state == addressState){
				
				return statusCode.SUCCESS;
			}else{
			
			return statusCode.FAILURE;
		}	
		}//end of checkStreet

		
		
		
		
		public statusCode checkZip(String zip, String addressZip){
			
			if(zip == addressZip){
				
				return statusCode.SUCCESS;
			}else{
			
			return statusCode.FAILURE;
		}
		
		}//end of checkZip
		
		
		

		public statusCode checkDesc(String desc, String addressDesc){
			
			if(desc == addressDesc){
				
				return statusCode.SUCCESS;
			}else{
			
			return statusCode.FAILURE;
		}
		}//end checkDesc
		
		
		public statusCode checkPrice(double price, double addressPrice){
			
			if(price == price){
				
				return statusCode.SUCCESS;
			}else{
			
			return statusCode.FAILURE;
		}
		
			
		}
				
			
		
		
}//end of class

