import java.util.*;

class PacketRepack{
	public static int output(int[] input, int b, int num_fields, int field_size) {
		int N = b * field_size;

		char[] binRep = new char[N];

		int counter = N - 1;
		for (int a:input) {
			String binString = Integer.toBinaryString(a);

			if (b > binString.length()) {
				int padding =  b - binString.length();

				binString = pad(binString, padding);
			}
			for (int i = b - 1; i >= 0; i--) {
				binRep[counter--] = binString.charAt(i);
			}
		}

		convert(binString, num_fields, field_size);
		return 1;
	}

	public static String pad(String s, int padding) {
		for (int i = 0; i < padding; i++) {
			s = "0" + s;
		}
		return s;
	}

	public static void convert(char[] ary, int nfields, int fSize) {
		int mid = nfields / 2;

		for (int i = 0; i < mid; i++) {
			
		}
	}

	public static void main(String[] args){
		int[] input = {27, 37, 3};
		int b = 6;
		int num_fields = 4;
		int field_size = 4;

		output(input, b, num_fields, field_size);
	}
}