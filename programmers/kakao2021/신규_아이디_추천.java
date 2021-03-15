package kakao2021;


public class 신규_아이디_추천 {

	public static void main(String[] args) {
		String new_id="...!@BaT#*..y.abcdefghijklm";
		new_id.toLowerCase();
		
		// ...!@BaT#*..y.abcdefghijklm
		String temp="";
		for(int i=0; i<new_id.length(); i++) {
			char now=new_id.charAt(i);
			if((now>='a' && now<='z') || now=='-' ||now=='_' || now=='.' || (now>='0' && now<='9')) temp+=now;
		}
		String temp2="";
		for(int i=0; i<temp.length(); i++) {
			System.out.println(temp2);
			int now=i;
			if(temp.charAt(now)=='.') {
				temp2+='.';
				
				for(int j=now+1; j<temp.length(); j++) {
					if(temp.charAt(j)!='.') {
						break;
					}
					i++;	// 1 2
				}
			}
			else {
				temp2+=temp.charAt(i);
			}
		}
		
		if(temp2.charAt(0)=='.') temp2=temp2.substring(0, temp2.length());
		
		if(temp2.length()!=0 && temp2.charAt(temp2.length()-1)=='.') temp2=temp2.substring(0, temp2.length()-1);
		if(temp2.length()==0) temp2="a";
		if(temp2.length()>=16) { temp2=temp2.substring(0, 15);
			if(temp2.charAt(temp2.length()-1)=='.') temp2=temp2.substring(0, temp2.length()-1);
		}
		if(temp2.length()<=2) {
			char c=temp2.charAt(temp2.length()-1);
			while(temp2.length()<3) {
				temp2+=c;
			}
		}
		
		System.out.println(temp2);
	}

}
