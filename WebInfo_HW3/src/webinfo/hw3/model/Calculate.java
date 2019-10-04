package webinfo.hw3.model;

public class Calculate {
	private String num1;
	private String num2;
	private String sign;
	
	public Calculate() {}
	
	public Calculate(String num1, String num2, String sign) {
		this.num1 = num1;
		this.num2 = num2;
		this.sign = sign;
	}
	
	public float calcul() {
		float num1 = Float.valueOf(this.num1);
		float num2 = Float.valueOf(this.num2);
		
		return calcul(num1, num2, sign);
	}
	
	public float calcul(float num1, float num2, String sign) {
		float result = 0;

		switch (sign) {
		case "sum":
			result = num1 + num2;
			break;
		case "sub":
			result = num1 - num2;
			break;
		case "mul":
			result = num1 * num2;
			break;
		case "div":
			result = num1 / num2;
			break;
		}

		return result;
	}
	
	public String getResultStr() {
		String resultStr = num1;
		String result = Float.toString(this.calcul());
		
		switch (sign) {
		case "sum":
			resultStr += " + ";
			break;
		case "sub":
			resultStr += " - ";
			break;
		case "mul":
			resultStr += " * ";
			break;
		case "div":
			resultStr += " / ";
			break;
		}
		
		resultStr += num2 + " = ";
		
		// 계산결과가 float범위를 넘어서는지 확인
		if (result.equals("Infinity"))
			resultStr += "<br>계산 가능 범위를 초과했습니다";
		else
			resultStr += result;
			
		return resultStr;
	}
}
