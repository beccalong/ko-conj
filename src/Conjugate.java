import java.util.*;

public class Conjugate {
	
	public static void main (String[] args) {
		if (args.length == 1) {
			
			Dict dict = new Dict();
			ArrayList<VerbEntry> entries = dict.get(args[0]);
			
			if (entries != null) {
								
				for (VerbEntry v : entries) {
					
					Forms forms = conjugate(args[0], v.getFunction(), v.isIrreg(), v.isReg(), v.isHortative(), 
							v.isImperative(), v.isHonimperative(), v.isHonorific());
					System.out.println(v.getFullPos().toUpperCase() + forms.toString());
				}
			} else {
				
				System.out.println("Error: Word is not in the dictionary");
			}
			
		} else if (args.length == 8) {
			
			Forms forms = conjugate(args[0], args[1], args[2].equals("true"), args[3].equals("true"), 
					args[4].equals("true"), args[5].equals("true"), args[6].equals("true"), 
					args[7].equals("true"));
			System.out.println(forms.toString());
			
		} else {
			
			System.out.println("Error: wrong number of arguments");
		}
	}
	
	/*
	 * defaults
	 * irreg = false
	 * reg = false
	 * hor = true
	 * imperative = true
	 * honimperative = true
	 * hon = true
	 */
	public static Forms conjugate(String word, String pos, boolean irreg, boolean reg,
			boolean hortative, boolean imperative, boolean honimperative, boolean honorific) {
		
		if (pos.equals("A")) {
			return exportAdjective(word, irreg, honorific);
		} else {
			return exportVerb(word, irreg, reg, hortative, imperative, honimperative, honorific);
		}
	}
	
	private static Forms exportAdjective(String word, 
								boolean irreg, 
								boolean hon) {
		
		boolean honorific = hon;
		
		String irregtype = "";
		String haet = "";
		String stem2 = "";
		String stem3 = "";
		String hal = "";
		String ham = "";
		String han = "";
		String hap = "";
		String cstem = "";
		String stem2a = "";
		String hayeot = "";
		String antepenultimate, penultimate_vowel;
		int penultimate;
		
		String stem1 = word.substring(0, word.length()-1);
		String prestem1 = stem1.substring(0, stem1.length()-1);
		int stem1last_basic = stem1.codePointAt(stem1.length()-1);
		int stem1last = stem1last_basic - 0xAC00;
		int stem1_jongseong = stem1last % 28;
		
		if (stem1_jongseong != 0) {
			
			stem1_jongseong = 0x11A7 + stem1_jongseong;
		}
		
		double stem1_jungseong = Math.floor((stem1last % 588) / 28);
		stem1_jungseong = 0x1161 + stem1_jungseong;
		String stem1_jungseong_string = Character.toString((char)stem1_jungseong);
		
		if (stem1_jongseong == 0) { // if stem1 does not have a final consonant
			
			hal = prestem1 + Character.toString((char)(stem1last_basic + 8));
			ham = prestem1 + Character.toString((char)(stem1last_basic + 16));
			han = prestem1 + Character.toString((char)(stem1last_basic + 4));
			hap = prestem1 + Character.toString((char)(stem1last_basic + 17));
			
			if (stem1_jungseong_string.equals("ᅡ")) {
				
				if (stem1.codePointAt(stem1.length()-1) == 54616) {
					
					irregtype = "ha";
					stem2 = prestem1 + Character.toString((char)(stem1last_basic + 28));
					haet = prestem1 + "했";
					stem2a = stem1 + "여";
					hayeot = stem1 + "였";
					
				} else {
					
					haet = prestem1 + Character.toString((char)(stem1last_basic + 20));
				}
			} else if (stem1_jungseong_string.equals("ᅵ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic - 392));
				haet = prestem1 + Character.toString((char)(stem1last_basic - 372));
				
				if (stem1.codePointAt(stem1.length()-1) == 49884 && irreg) {
					
					irregtype = "si";
					honorific = false;
					stem2a = prestem1 + "세";
					
				} else if (stem1.codePointAt(stem1.length()-1) == 51060 && irreg) {
					
					irregtype = "i";
					stem2 = stem1 + "에";
					stem2a = stem1 + "어";
					haet = stem1 + "었";
					
				} else {
					
					stem2a = stem1 + "어";
					hayeot = stem1 + "었";
				}
			} else if (stem1_jungseong_string.equals("ᅢ") || stem1_jungseong_string.equals("ᅦ")) {
				
				haet = prestem1 + Character.toString((char)(stem1last_basic + 20));
				stem2a = stem1 + "어";
				hayeot = stem1 + "었";
				
			} else if (stem1_jungseong_string.equals("ᅩ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic + 28));
				stem2a = stem1 + "아";
				haet = prestem1 + Character.toString((char)(stem1last_basic + 48));
				hayeot = stem1 + "았";
				
			} else if (stem1_jungseong_string.equals("ᅬ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic - 28));
				stem2a = stem1 + "어";
				haet = prestem1 + Character.toString((char)(stem1last_basic - 8));
				hayeot = stem1 + "었";
				
			} else if (stem1_jungseong_string.equals("ᅳ")) {
				
				if (stem1.codePointAt(stem1.length()-1) == 47476) {
					
					if (stem1.length() >= 2 &&
							(stem1.substring(stem1.length()-2).equals("누르") || 
							stem1.substring(stem1.length()-2).equals("노르") ||
							stem1.substring(stem1.length()-2).equals("푸르"))) {
						
						irregtype = "reo";
						stem2 = stem1 + "러";
						haet = stem1 + "렀";
						
					} else {
						
						irregtype = "reu";
						antepenultimate = prestem1.substring(0, prestem1.length()-2);
						penultimate = prestem1.codePointAt(prestem1.length()-1);
						penultimate_vowel = Character.toString((char)(0x1161 + Math.floor((((penultimate - 0xAC00) % 588) / 28))));
						
						if (penultimate_vowel.equals("ᅡ") || penultimate_vowel.equals("ᅩ")) {
							
							stem2 = antepenultimate + Character.toString((char)(penultimate + 8)) + "라";
							haet = antepenultimate + Character.toString((char)(penultimate + 8)) + "랐";
							
						} else {
							
							stem2 = antepenultimate + Character.toString((char)(penultimate + 8)) + "러";
							haet = antepenultimate + Character.toString((char)(penultimate + 8)) + "렀";
						}
					}
				} else {
					
					if (stem1.length() != 1) {
						
						penultimate = prestem1.codePointAt(prestem1.length()-1);
						penultimate_vowel = Character.toString((char)(0x1161 + Math.floor((((penultimate - 0xAC00) % 588) / 28))));
						
					} else {
						
						penultimate_vowel = "ᅥ";
					}
					if (penultimate_vowel.equals("ᅡ") || penultimate_vowel.equals("ᅩ")) {
						
						stem2 = prestem1 + Character.toString((char)(stem1last_basic - 504));
						haet = prestem1 + Character.toString((char)(stem1last_basic - 484));
						
					} else {
						
						stem2 = prestem1 + Character.toString((char)(stem1last_basic - 392));
						haet = prestem1 + Character.toString((char)(stem1last_basic - 372));
					}
				}
			} else if (stem1_jungseong_string.equals("ᅮ")) {
				
				if (stem1.substring(stem1.length()-1).equals("우")) {
					
					stem2 = prestem1 + "워";
					haet = prestem1 + "웠";
					
				} else {
					
					stem2 = stem1 + "어";
					stem2a = prestem1 + Character.toString((char)(stem1last_basic + 28));
					haet = stem1 + "었";
					hayeot = prestem1 + Character.toString((char)(stem1last_basic + 48));
				}
			} else {
				
				stem2 = stem1 + "어";
				haet = stem1 + "었";
			}
		} else {
			
			String stem1_jongseong_string = Character.toString((char)stem1_jongseong);
			
			if (irreg) {
				
				if (stem1_jongseong_string.equals("ᇂ")) {
					
					cstem = "y";
					irregtype = "h";
					
					if (stem1.length() >= 2 && (stem1.substring(stem1.length()-2).equals("이렇") ||
												stem1.substring(stem1.length()-2).equals("요렇") ||
												stem1.substring(stem1.length()-2).equals("그렇") ||
												stem1.substring(stem1.length()-2).equals("고렇") ||
												stem1.substring(stem1.length()-2).equals("저렇") ||
												stem1.substring(stem1.length()-2).equals("조렇") ||
												stem1.substring(stem1.length()-2).equals("무렇") ||
												stem1.substring(stem1.length()-2).equals("어떻"))) {
						
						irregtype = "det_h";
						stem2 = prestem1 + Character.toString((char)(stem1last_basic - 111));
						haet = prestem1 + Character.toString((char)(stem1last_basic - 91));
						
					} else {
						
						stem2 = prestem1 + Character.toString((char)(stem1last_basic + 1));
						haet = prestem1 + Character.toString((char)(stem1last_basic + 21));
					}
					stem3 = prestem1 + Character.toString((char)(stem1last_basic - 27));
					hal = prestem1 + Character.toString((char)(stem1last_basic - 19));
					ham = prestem1 + Character.toString((char)(stem1last_basic - 11));
					han = prestem1 + Character.toString((char)(stem1last_basic - 23));
					
				} else if (stem1_jongseong_string.equals("ᆺ")) {
					
					cstem = "y";
					irregtype = "s";
					String de_s = Character.toString((char)(stem1last_basic - 19));
					stem3 = prestem1 + de_s + "으";
					ham = prestem1 + de_s + "음";
					hal = prestem1 + de_s + "을";
					han = prestem1 + de_s + "은";
					
					if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
						
						stem2 = prestem1 + de_s + "아";
						haet = prestem1 + de_s + "았";
						
					} else {
						
						stem2 = prestem1 + de_s + "어";
						haet = prestem1 + de_s + "었";
					}
				} else if (stem1_jongseong_string.equals("ᆸ") || stem1_jongseong_string.equals("ᆲ")) {
					
					cstem = "y";
					irregtype = "p";
					String de_p;
					if (stem1_jongseong_string.equals("ᆲ")) {
						
						de_p = Character.toString((char)(stem1last_basic - 3));
					} else {
						
						de_p = Character.toString((char)(stem1last_basic - 17));
					}
					stem3 = prestem1 + de_p + "우";
					ham = prestem1 + de_p + "움";
					hal = prestem1 + de_p + "울";
					han = prestem1 + de_p + "운";
					
					if (stem1.length() == 1) {
						
						if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
							
							stem2 = prestem1 + de_p + "와";
							haet = prestem1 + de_p + "왔";
							
						} else {
							
							stem2 = prestem1 + de_p + "워";
							haet = prestem1 + de_p + "웠";
						}
					} else {
						
						stem2 = prestem1 + de_p + "워";
						haet = prestem1 + de_p + "웠";
					}
				} else {
					
					System.out.println("Error: Irregular \"irregtype\" unrecognised.");
				}
			} else if (stem1_jongseong_string.equals("ᆯ")) {
				
				cstem = "n";
				irregtype = "l";
				stem3 = prestem1 + Character.toString((char)(stem1last_basic - 8));
				ham = prestem1 + Character.toString((char)(stem1last_basic + 2));
				hal = stem1;
				han = prestem1 + Character.toString((char)(stem1last_basic - 4));
				hap = prestem1 + Character.toString((char)(stem1last_basic + 9));
				
				if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
					
					stem2 = stem1 + "아";
					
				} else {
					
					stem2 = stem1 + "어";
				}
			} else {
				
				cstem = "y";
				stem3 = stem1 + "으";
				
				if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
					
					stem2 = stem1 + "아";
					
				} else {
					
					stem2 = stem1 + "어";
				}
			}
		}
		if (haet.isEmpty()) {
			
			if (stem2.equals(stem1 + "어")) {
				
				haet = stem1 + "었";
				
			} else if (stem2.equals(stem1 + "아")) {
				
				haet = stem1 + "았";
			}
		}
		if (stem2.isEmpty()) {
			
			stem2 = stem1;
		}
		if (stem3.isEmpty()) {
			
			stem3 = stem1;
		}
		if (ham.isEmpty()) {
			
			ham = stem1 + "음";
		}
		if (hal.isEmpty()) {
			
			hal = stem1 + "을";
		}
		if (han.isEmpty()) {
			
			if (stem1.substring(stem1.length()-1).equals("있") || 
				stem1.substring(stem1.length()-1).equals("없")) {
				
				irregtype = "ex";
				han = stem1 + "는";
				
			} else {
				
				han = stem1 + "은";
			}
		}
		
		Forms forms = new Forms(word);
		forms.lemma = stem1 + "다";
		forms.ind_hrc = stem1 + "다";
		forms.ind_hrc_past = haet + "다";
		forms.ind_hc = stem2;
		forms.ind_hc_past = haet + "어";
		forms.ind_hyc = stem2 + "요";
		forms.ind_hyc_past = haet + "어요";
		forms.ind_hssoc_past = haet + "습니다";
		forms.interrog_hrc = stem3 + "냐";
		forms.interrog_hrc_past = haet + "냐";
		forms.interrog_hc = stem2;
		forms.interrog_hc_past = haet + "어";
		forms.interrog_hyc = stem2 + "요";
		forms.interrog_hyc_past = haet + "어요";
		forms.interrog_hssoc_past = haet + "습니까";
		forms.assert_hrc = stem1 + "겠다";
		forms.assert_hc = stem1 + "겠어";
		forms.assert_hyc = stem1 + "겠어요";
		forms.assert_hssoc = stem1 + "겠습니다";
		forms.realize_hc = stem1 + "구나";
		forms.realize_hyc = stem1 + "군요";
		forms.realize_hc_past = haet + "구나";
		forms.realize_hyc_past = haet + "군요";
		forms.realize_assert_hc = stem1 + "겠구나";
		forms.realize_assert_hyc = stem1 + "겠군요";
		forms.cause_hrc = stem2;
		forms.cause_hc = stem2 + "서";
		forms.cause_hyc = stem3 + "니";
		forms.cause_hssoc = stem3 + "니까";
		forms.contrast_hrc = stem1 + "지만";
		forms.contrast_hc = han + "데";
		forms.contrast_hyc = stem1 + "더니";
		forms.conjunction = stem1 + "고";
		forms.condition_hc = stem2 + "야";
		forms.vn_um = ham;
		forms.vn_gi = stem1 + "기";
		forms.vn_um_past = haet + "음";
		forms.vn_gi_past = haet + "기";
		forms.determ_pres = han;
		forms.determ_fut = hal;
		
		if (!irregtype.equals("ha") && !irregtype.equals("i")) {
			
			if (!stem2a.isEmpty()) {
				
				forms.ind_hyc_alt = stem2a + "요";
				forms.interrog_hyc_alt = stem2a + "요";
			}
		}
		if (irregtype.equals("i")) {
			
			forms.ind_hc = stem1 + "야";
			forms.interrog_hc = stem1 + "야";
			forms.ind_hyc_alt = prestem1 + "예요";
			forms.interrog_hyc_alt = prestem1 + "예요";
			forms.interrog_hrc_past = haet + "느냐";
			forms.cause_hc = stem2a + "서";
			forms.condition_hc = stem2a + "야";
			
			// generate forms of 이다 for vowel-final conjugation
			// Should work since 이다 is the only adjective that conjugates into 이었 (I think).
			// Maybe kind of hack-y...
			if (word.equals("이다")) {
				
				forms.ind_hrc_past_alt = forms.ind_hrc_past.replace("이었", "였");
				forms.ind_hc_past_alt = forms.ind_hc_past.replace("이었", "였");
				forms.ind_hyc_past_alt = forms.ind_hyc_past.replace("이었", "였");
				forms.ind_hssoc_past_alt = forms.ind_hssoc_past.replace("이었", "였");
				forms.interrog_hrc_past_alt = forms.interrog_hrc_past.replace("이었", "였");
				forms.interrog_hc_past_alt = forms.interrog_hc_past.replace("이었", "였");
				forms.interrog_hyc_past_alt = forms.interrog_hyc_past.replace("이었", "였");
				forms.interrog_hssoc_past_alt = forms.interrog_hssoc_past.replace("이었", "였");
				forms.realize_hc_alt = "구나";
				forms.realize_hyc_alt = "군요";
				forms.vn_um_past_alt = forms.vn_um_past.replace("이었", "였");
				forms.vn_gi_past_alt = forms.vn_gi_past.replace("이었", "였");
			}
		}
		if (stem1.substring(stem1.length()-1).equals("있") || 
			stem1.substring(stem1.length()-1).equals("없")) {
			
			forms.interrog_hrc = stem1 + "느냐";
			forms.interrog_hrc_past = haet + "느냐";
		}
		if (cstem.equals("y")) {
			
			forms.ind_hssoc = stem1 + "습니다";
			forms.interrog_hssoc = stem1 + "습니까";
			
		} else {
			
			if (hap.isEmpty()) {
				
				forms.ind_hssoc = stem1 + "읍니다";
				forms.interrog_hssoc = stem1 + "읍니까";
				
			} else {
				
				forms.ind_hssoc = hap + "니다";
				forms.interrog_hssoc = hap + "니까";
			}
		}
		if (stem1.equals(hal)) {
			
			forms.condition_hrc = stem1 + "면";
			
		} else {
			
			forms.condition_hrc = stem3 + "면";
		}
		if (!stem2a.isEmpty() && 
			!irregtype.equals("si") && 
			!irregtype.equals("i")) {
			
			forms.cause_hc_alt = stem2a + "서";
			forms.condition_hc_alt = stem2a + "야";
		}
		if (!hayeot.isEmpty()) {
			
			forms.vn_um_past_alt = hayeot + "음";
			forms.vn_gi_past_alt = hayeot + "기";
		}
		
		if (honorific) {
			
			forms.hon_ind_hrc = stem3 + "시다";
			forms.hon_ind_hrc_past = stem3 + "셨다";
			forms.hon_ind_hc = stem3 + "셔";
			forms.hon_ind_hc_past = stem3 + "셨어";
			forms.hon_ind_hyc = stem3 + "세요";
			forms.hon_ind_hyc_alt = stem3 + "셔요";
			forms.hon_ind_hyc_past = stem3 + "셨어요";
			forms.hon_ind_hsc = stem3 + "십니다";
			forms.hon_ind_hsc_past = stem3 + "셨습니다";
			forms.hon_interrog_hrc = stem3 + "시냐";
			forms.hon_interrog_hrc_past = stem3 + "셨냐";
			forms.hon_interrog_hc = stem3 + "셔";
			forms.hon_interrog_hc_past = stem3 + "셨어";
			forms.hon_interrog_hyc = stem3 + "세요";
			forms.hon_interrog_hyc_alt = stem3 + "셔요";
			forms.hon_interrog_hyc_past = stem3 + "셨어요";
			forms.hon_interrog_hsc = stem3 + "십니까";
			forms.hon_interrog_hsc_past = stem3 + "셨습니까";
			forms.hon_assert_hrc = stem3 + "시겠다";
			forms.hon_assert_hc = stem3 + "시겠어";
			forms.hon_assert_hyc = stem3 + "시겠어요";
			forms.hon_assert_hsc = stem3 + "시겠습니다";
			forms.hon_cause_hrc = stem3 + "셔";
			forms.hon_cause_hc = stem3 + "셔서";
			forms.hon_cause_hyc = stem3 + "시니";
			forms.hon_cause_hsc = stem3 + "시니까";
			forms.hon_contrast_hrc = stem3 + "시지만";
			forms.hon_contrast_hc = stem3 + "신데";
			forms.hon_contrast_hyc = stem3 + "시더니";
			forms.hon_conjunction = stem3 + "시고";
			forms.hon_condition_hrc = stem3 + "시면";
			forms.hon_condition_hc = stem3 + "셔야";
			forms.hon_vn_um = stem3 + "심";
			forms.hon_vn_gi = stem3 + "시기";
			forms.hon_vn_um_past = stem3 + "셨음";
			forms.hon_vn_gi_past = stem3 + "셨기";
			forms.hon_determ_pres = stem3 + "신";
			forms.hon_determ_fut = stem3 + "실";
		}
		return forms;
	}
	
	private static Forms exportVerb(String word, 
							boolean irreg, 
							boolean reg, 
							boolean hor, 
							boolean imperative, 
							boolean honimperative, 
							boolean hon) {
		
		boolean hortative = hor;
		boolean honorific = hon;
		
		String irregtype = "";
		String haet = "";
		String stem1a = "";
		String stem2 = "";
		String stem3 = "";
		String hal = "";
		String ham = "";
		String han = "";
		String hap = "";
		String cstem = "";
		String stem2a = "";
		String stem2b = "";
		String hayeot = "";
		String antepenultimate, penultimate_vowel;
		int penultimate;
		
		String stem1 = word.substring(0, word.length()-1);
		String prestem1 = stem1.substring(0, stem1.length()-1);
		int stem1last_basic = stem1.codePointAt(stem1.length()-1);
		int stem1last = stem1last_basic - 0xAC00;
		int stem1_jongseong = stem1last % 28;
		
		if (stem1_jongseong != 0) {
			
			stem1_jongseong = 0x11A7 + stem1_jongseong;
		}
		
		double stem1_jungseong = Math.floor((stem1last % 588) / 28);
		stem1_jungseong = 0x1161 + stem1_jungseong;
		String stem1_jungseong_string = Character.toString((char)stem1_jungseong);
		
		if (stem1_jongseong == 0) {
			
			hal = prestem1 + Character.toString((char)(stem1last_basic + 8));
			ham = prestem1 + Character.toString((char)(stem1last_basic + 16));
			han = prestem1 + Character.toString((char)(stem1last_basic + 4));
			hap = prestem1 + Character.toString((char)(stem1last_basic + 17));
			
			if (stem1_jungseong_string.equals("ᅡ")) {
				
				if (stem1.codePointAt(stem1.length()-1) == 54616) {
					
					irregtype = "ha";
					stem2 = prestem1 + Character.toString((char)(stem1last_basic + 28));
					haet = prestem1 + "했";
					stem2a = stem1 + "여";
					hayeot = stem1 + "였";
					
				} else {
					
					haet = prestem1 + Character.toString((char)(stem1last_basic + 20));
					if (stem1.codePointAt(stem1.length()-1) == 44032) {
						
						if (!reg) {
							
							irregtype = "ga";
							stem2a = stem1 + "거";
							stem2b = "가오";
						}
					}
				}
			} else if (stem1_jungseong_string.equals("ᅵ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic - 392));
				haet = prestem1 + Character.toString((char)(stem1last_basic - 372));
				
				if (stem1.codePointAt(stem1.length()-1) == 49884) {
					
					if (irreg) {
						
						irregtype = "si";
						hortative = false;
						honorific = false;
						stem2a = prestem1 + "세";
					}
				}
				
				if (!irregtype.equals("si")) {
					
					stem2a = stem1 + "어";
					hayeot = stem1 + "었";
				}
			} else if (stem1_jungseong_string.equals("ᅢ") || stem1_jungseong_string.equals("ᅦ")) {
				
				haet = prestem1 + Character.toString((char)(stem1last_basic + 20));
				stem2a = stem1 + "어";
				hayeot = stem1 + "었";
				
			} else if (stem1_jungseong_string.equals("ᅩ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic + 28));
				haet = prestem1 + Character.toString((char)(stem1last_basic + 48));
				
				if (stem1.codePointAt(stem1.length()-1) == 50724) {
					
					if (!reg) {
						
						irregtype = "o";
						stem2a = stem1 + "너";
						stem2b = "가오";
						
					} else {
						
						stem2a = stem1 + "아";
						hayeot = stem1 + "았";
					}
				} else {
					
					stem2a = stem1 + "아";
					hayeot = stem1 + "았";
				}
			} else if (stem1_jungseong_string.equals("ᅬ")) {
				
				stem2 = prestem1 + Character.toString((char)(stem1last_basic - 28));
				haet = prestem1 + Character.toString((char)(stem1last_basic - 8));
				stem2a = stem1 + "어";
				hayeot = stem1 + "었";
				
			} else if (stem1_jungseong_string.equals("ᅳ")) {
				
				if (stem1.codePointAt(stem1.length()-1) == 47476) {

					if ((stem1.length() >= 2 && 
							(stem1.substring(stem1.length()-2).equals("따르") || 
							stem1.substring(stem1.length()-2).equals("치르") || 
							stem1.substring(stem1.length()-2).equals("들르"))) || 
						(stem1.length() >= 3 &&
							(stem1.substring(stem1.length()-3).equals("다다르") || 
							stem1.substring(stem1.length()-3).equals("우러르")))) {

						stem2 = prestem1 + "라";
						haet = prestem1 + "랐";

					} else if (stem1.length() >= 2 &&
							(stem1.substring(stem1.length()-2).equals("이르") && irreg)) {

						irregtype = "reo";
						stem2 = stem1 + "러";
						haet = stem1 + "렀";
						
					} else {
						
						irregtype = "reu";
						if (prestem1.length() > 1) {
							antepenultimate = prestem1.substring(0, prestem1.length()-2);
						} else {
							antepenultimate = "";
						}
						penultimate = prestem1.codePointAt(prestem1.length()-1);
						penultimate_vowel = Character.toString((char)(0x1161 + Math.floor((((penultimate - 0xAC00) % 588) / 28))));
						
						if (penultimate_vowel.equals("ᅡ") || penultimate_vowel.equals("ᅩ")) {
							
							stem2 = antepenultimate + Character.toString((char)(penultimate + 8)) + "라";
							haet = antepenultimate + Character.toString((char)(penultimate + 8)) + "랐";
							
						} else {
							
							stem2 = antepenultimate + Character.toString((char)(penultimate + 8)) + "러";
							haet = antepenultimate + Character.toString((char)(penultimate + 8)) + "렀";
						}
					}
				} else {
					
					if (stem1.length() != 1) {
						
						penultimate = prestem1.codePointAt(prestem1.length()-1);
						penultimate_vowel = Character.toString((char)(0x1161 + Math.floor((((penultimate - 0xAC00) % 588) / 28))));
						
					} else {
						
						penultimate_vowel = "ᅥ";
					}
					if (penultimate_vowel.equals("ᅡ") || penultimate_vowel.equals("ᅩ")) {
						
						stem2 = prestem1 + Character.toString((char)(stem1last_basic - 504));
						haet = prestem1 + Character.toString((char)(stem1last_basic - 484));
						
					} else {
						
						stem2 = prestem1 + Character.toString((char)(stem1last_basic - 392));
						haet = prestem1 + Character.toString((char)(stem1last_basic - 372));
					}
				}
			} else if (stem1_jungseong_string.equals("ᅮ")) {
				
				if (irreg) {
					
					irregtype = "u";
					stem2 = prestem1 + Character.toString((char)(stem1last_basic - 252));
					haet = prestem1 + Character.toString((char)(stem1last_basic - 232));
					
				} else if (stem1.substring(stem1.length()-1).equals("우")) {
					
					stem2 = prestem1 + "워";
					haet = prestem1 + "웠";
					
				} else {
					
					stem2 = stem1 + "어";
					haet = stem1 + "었";
					stem2a = prestem1 + Character.toString((char)(stem1last_basic - 28));
					hayeot = prestem1 + Character.toString((char)(stem1last_basic - 48));
				}
			} else if (stem1_jungseong_string.equals("ᅥ") && irreg) {
				
				irregtype = "eo";
				stem2 = prestem1 + Character.toString((char)(stem1last_basic - 84));
				haet = prestem1 + Character.toString((char)(stem1last_basic - 64));
				
			} else {
				
				stem2 = stem1 + "어";
				haet = stem1 + "었";
			}
		} else {
			
			String stem1_jongseong_string = Character.toString((char)stem1_jongseong);
			
			if (irreg) {
				
				if (stem1_jongseong_string.equals("ᆺ")) {
					
					cstem = "y";
					irregtype = "s";
					String de_s = Character.toString((char)(stem1last_basic - 19));
					stem3 = prestem1 + de_s + "으";
					ham = prestem1 + de_s + "음";
					hal = prestem1 + de_s + "을";
					han = prestem1 + de_s + "은";
					hap = prestem1 + de_s + "읍";
					
					if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
						
						stem2 = prestem1 + de_s + "아";
						haet = prestem1 + de_s + "았";
						
					} else {
						
						stem2 = prestem1 + de_s + "어";
						haet = prestem1 + de_s + "었";
					}
				} else if (stem1_jongseong_string.equals("ᆸ")) {
					
					cstem = "y";
					irregtype = "p";
					String de_p = Character.toString((char)(stem1last_basic - 17));
					stem3 = prestem1 + de_p + "우";
					ham = prestem1 + de_p + "움";
					hal = prestem1 + de_p + "울";
					han = prestem1 + de_p + "운";
					
					if (stem1.length() == 1) {
						
						if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
							
							stem2 = prestem1 + de_p + "와";
							haet = prestem1 + de_p + "왔";
							
						} else {
							
							stem2 = prestem1 + de_p + "워";
							haet = prestem1 + de_p + "웠";
						}
					} else {
						
						stem2 = prestem1 + de_p + "워";
						haet = prestem1 + de_p + "웠";
					}
				} else if (stem1_jongseong_string.equals("ᆮ")) {
					
					cstem = "y";
					irregtype = "d";
					String d_to_r = Character.toString((char)(stem1last_basic + 1));
					hal = prestem1 + d_to_r + "을";
					ham = prestem1 + d_to_r + "음";
					han = prestem1 + d_to_r + "은";
					hap = prestem1 + d_to_r + "읍";
					stem3 = prestem1 + d_to_r + "으";
					
					if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
						
						stem2 = prestem1 + d_to_r + "아";
						haet = prestem1 + d_to_r + "았";
						
					} else {
						
						stem2 = prestem1 + d_to_r + "어";
						haet = prestem1 + d_to_r + "었";
					}
				} else {
					
					System.out.println("Error: Irregular \"irregtype\" unrecognised.");
				}
			} else if (stem1_jongseong_string.equals("ᆯ")) {
				
				irregtype = "l";
				cstem = "n";
				stem1a = prestem1 + Character.toString((char)(stem1last_basic - 8));
				stem3 = prestem1 + Character.toString((char)(stem1last_basic - 8));
				ham = prestem1 + Character.toString((char)(stem1last_basic + 2));
				hal = stem1;
				han = prestem1 + Character.toString((char)(stem1last_basic - 4));
				hap = prestem1 + Character.toString((char)(stem1last_basic + 9));
				
				if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
					
					stem2 = stem1 + "아";
					
				} else {
					
					stem2 = stem1 + "어";
				}
			} else {
				
				cstem = "y";
				stem3 = stem1 + "으";
				
				if (stem1_jungseong_string.equals("ᅡ") || stem1_jungseong_string.equals("ᅩ")) {
					
					stem2 = stem1 + "아";
					
					if (stem1.substring(stem1.length()-1).equals("놓")) {
						
						irregtype = "noh";
						stem2a = stem1.replace("놓", "놔");
					}
				} else {
					
					stem2 = stem1 + "어";
				}
			}
		}
		if (haet.isEmpty()) {
			
			if (stem2.equals(stem1 + "어")) {
				
				haet = stem1 + "었";
				
			} else if (stem2.equals(stem1 + "아")) {
				
				haet = stem1 + "았";
			}
		}
		
		if (stem1a.isEmpty()) {
			
			stem1a = stem1;
		}
		if (stem2.isEmpty()) {
			
			stem2 = stem1;
		}
		if (stem3.isEmpty()) {
			
			stem3 = stem1;
		}
		if (han.isEmpty()) {
			
			han = stem1 + "은";
		}
		if (ham.isEmpty()) {
			
			ham = stem1 + "음";
		}
		if (hal.isEmpty()) {
			
			hal = stem1 + "을";
		}
		if (hap.isEmpty()) {
			
			hap = stem1 + "읍";
		}
		
		Forms forms = new Forms(word);
		forms.lemma = stem1;
		forms.ind_hrc_past = haet + "다";
		forms.ind_hc = stem2;
		forms.ind_hc_past = haet + "어";
		forms.ind_hyc = stem2 + "요";
		forms.ind_hyc_past = haet + "어요";
		forms.ind_hssoc_past = haet + "습니다";
		forms.interrog_hrc = stem1a + "느냐";
		forms.interrog_hrc_past = haet + "느냐";
		forms.interrog_hc = stem2;
		forms.interrog_hc_past = haet + "어";
		forms.interrog_hyc = stem2 + "요";
		forms.interrog_hyc_past = haet + "어요";
		forms.interrog_hssoc_past = haet + "습니까";
		forms.assert_hrc = stem1 + "겠다";
		forms.assert_hc = stem1 + "겠어";
		forms.assert_hyc = stem1 + "겠어요";
		forms.assert_hssoc = stem1 + "겠습니다";
		forms.realize_hc = stem1 + "는구나";
		forms.realize_hyc = stem1 + "는군요";
		forms.realize_hc_past = haet + "구나";
		forms.realize_hyc_past = haet + "군요";
		forms.realize_assert_hc = stem1 + "겠구나";
		forms.realize_assert_hyc = stem1 + "겠군요";
		forms.cause_hrc = stem2;
		forms.cause_hc = stem2 + "서";
		forms.cause_hyc = stem3 + "니";
		forms.cause_hssoc = stem3 + "니까";
		forms.contrast_hrc = stem1 + "지만";
		forms.contrast_hc = stem1a + "는데";
		forms.contrast_hyc = stem1 + "더니";
		forms.conjunction = stem1 + "고";
		forms.condition_hc = stem2 + "야";
		forms.vn_um = ham;
		forms.vn_gi = stem1 + "기";
		forms.vn_um_past = haet + "음";
		forms.vn_gi_past = haet + "기";
		forms.determ_past = han;
		forms.determ_pres = stem1a + "는";
		forms.determ_fut = hal;
		
		if (cstem.equals("y")) {
			
			forms.ind_hrc = stem1 + "는다";
			forms.ind_hssoc = stem1 + "습니다";
			forms.interrog_hssoc = stem1 + "습니까";
			
		} else {
			
			forms.ind_hrc = han + "다";
			forms.ind_hssoc = hap + "니다";
			forms.interrog_hssoc = hap + "니까";
		}
		
		if (!irregtype.equals("ha")) {
			
			if (stem2b.isEmpty() && !stem2a.isEmpty()) {
				
				forms.ind_hyc_alt = stem2a + "요";
				forms.interrog_hyc_alt = stem2a + "요";
			}
		}
		
		if (!stem2a.isEmpty()) {
			
			if (stem2b.isEmpty() && !irregtype.equals("si")) {
				
				forms.cause_hc_alt = stem2a + "서";
				forms.condition_hc_alt = stem2a + "야";
			}
		}
		
		if (stem1.equals("hal")) {
			
			forms.condition_hrc = stem1 + "면";
			forms.motive = stem1 + "려고";
			
		} else {
			
			forms.condition_hrc = stem3 + "면";
			forms.motive = stem3 + "려고";
		}
		
		if (!hayeot.isEmpty()) {
			
			forms.vn_um_past_alt = hayeot + "음";
			forms.vn_gi_past_alt = hayeot + "기";
		}
		
		if (hortative) {
			
			forms.hortative_hrc = stem1 + "자";
			forms.hortative_hc = stem2;
			forms.hortative_hyc = stem2 + "요";
			
			if (!irregtype.equals("ha")) {
				
				if (!stem2a.isEmpty() && stem2b.isEmpty()) {
					
					forms.hortative_hyc_alt = stem2a + "요";
				}
			}
			forms.hortative_hssoc = hap + "시다";
		}
		
		if (imperative) {
			
			if (!irregtype.equals("si")) {
				
				if (!stem2b.isEmpty()) {
					
					forms.imperative_hrc = stem2a + "라";
					forms.imperative_hrc_alt = stem2 + "라";
					
				} else {
					
					forms.imperative_hrc = stem2 + "라";
					
					if (!stem2a.isEmpty()) {
						
						forms.imperative_hrc_alt = stem2a + "라";
					}
				}
				forms.imperative_hc = stem2;
			}
			forms.imperative_hyc = stem2 + "요";
			
			if (!irregtype.equals("ha")) {
				
				if (!stem2a.isEmpty() && stem2b.isEmpty()) {
					
					forms.imperative_hyc_alt = stem2a + "요";
				}
			}
			forms.imperative_hssoc = hap + "시오";
		}
		
		if (honorific) {
			
			forms.hon_ind_hrc = stem3 + "신다";
			forms.hon_ind_hrc_past = stem3 + "셨다";
			forms.hon_ind_hc = stem3 + "셔";
			forms.hon_ind_hc_past = stem3 + "셨어";
			forms.hon_ind_hyc = stem3 + "세요";
			forms.hon_ind_hyc_alt = stem3 + "셔요";
			forms.hon_ind_hyc_past = stem3 + "셨어요";
			forms.hon_ind_hsc = stem3 + "십니다";
			forms.hon_ind_hsc_past = stem3 + "셨습니다";
			forms.hon_interrog_hrc = stem3 + "시느냐";
			forms.hon_interrog_hrc_past = stem3 + "셨느냐";
			forms.hon_interrog_hc = stem3 + "셔";
			forms.hon_interrog_hc_past = stem3 + "셨어";
			forms.hon_interrog_hyc = stem3 + "세요";
			forms.hon_interrog_hyc_alt = stem3 + "셔요";
			forms.hon_interrog_hyc_past = stem3 + "셨어요";
			forms.hon_interrog_hsc = stem3 + "십니까";
			forms.hon_interrog_hsc_past = stem3 + "셨습니까";
			forms.hon_assert_hrc = stem3 + "시겠다";
			forms.hon_assert_hc = stem3 + "시겠어";
			forms.hon_assert_hyc = stem3 + "시겠어요";
			forms.hon_assert_hsc = stem3 + "시겠습니다";
			forms.hon_cause_hrc = stem3 + "셔";
			forms.hon_cause_hc = stem3 + "셔서";
			forms.hon_cause_hyc = stem3 + "시니";
			forms.hon_cause_hsc = stem3 + "시니까";
			forms.hon_contrast_hrc = stem3 + "시지만";
			forms.hon_contrast_hc = stem3 + "시는데";
			forms.hon_contrast_hyc = stem3 + "시더니";
			forms.hon_conjunction = stem3 + "시고";
			forms.hon_condition_hrc = stem3 + "시면";
			forms.hon_condition_hc = stem3 + "셔야";
			forms.hon_motive = stem3 + "시려고";
			forms.hon_vn_um = stem3 + "심";
			forms.hon_vn_gi = stem3 + "시기";
			forms.hon_vn_um_past = stem3 + "셨음";
			forms.hon_vn_gi_past = stem3 + "셨기";
			forms.hon_determ_past = stem3 + "신";
			forms.hon_determ_pres = stem3 + "시는";
			forms.hon_determ_fut = stem3 + "실";
		}
		
		if (honimperative) {
			
			forms.hon_imperative_hrc = stem3 + "시라";
			forms.hon_imperative_hc = stem3 + "셔";
			forms.hon_imperative_hyc = stem3 + "세요";
			forms.hon_imperative_hyc_alt = stem3 + "셔요";
			forms.hon_imperative_hsc = stem3 + "십시오";
		}
		return forms;
	}

}
