package principal;

public class primitiva {

	public static void main(String[] args) {
		int generados = 0;
		int[] nums = new int[6];
		int n;
		do{
			n=(int)(Math.random()*49+1);
			if(!repetido(n,nums,generados)) {
				nums[generados]=n;
				generados++;
			}
		}while(generados<6);
		ordernar(nums);
		mostrar(nums);
		
		

	}
	private static boolean repetido(int n, int[] nums, int generados) {
		
		for (int element : nums) {
			if(element == n) {
				return true;
			}
		}
		return false;
	}
	private static void ordernar(int[] nums) {
		
		int aux;
		for(int i=0;i<nums.length;i++) {
			for(int k=i;k<nums.length;k++) {
				if(nums[k]<nums[i]) {
					aux=nums[i];
					nums[i] = nums[k];
					nums[k]=aux;
				}
			}
		}
	}
	private static void mostrar(int[]nums) {
		for (int element : nums) {
			System.out.print(element+ ", ");
			
		}
	}

}
