public class Forms {
	
	public String word;
	public String lemma;
	
	// non honorific
	// sentence-final forms
	public String ind_hrc;
	public String ind_hrc_past;
	public String ind_hrc_past_alt; // only 이다
	public String ind_hc;
	public String ind_hc_past;
	public String ind_hc_past_alt; // only 이다
	public String ind_hyc;
	public String ind_hyc_alt;
	public String ind_hyc_past;
	public String ind_hyc_past_alt; // only 이다
	public String ind_hssoc;
	public String ind_hssoc_past;
	public String ind_hssoc_past_alt; // only 이다
	public String interrog_hrc;
	public String interrog_hrc_past;
	public String interrog_hrc_past_alt; // only 이다
	public String interrog_hc;
	public String interrog_hc_past;
	public String interrog_hc_past_alt; // only 이다
	public String interrog_hyc;
	public String interrog_hyc_alt;
	public String interrog_hyc_past;
	public String interrog_hyc_past_alt; // only 이다
	public String interrog_hssoc;
	public String interrog_hssoc_past;
	public String interrog_hssoc_past_alt; // only 이다
	public String hortative_hrc;
	public String hortative_hc;
	public String hortative_hyc;
	public String hortative_hyc_alt;
	public String hortative_hssoc;
	public String imperative_hrc;
	public String imperative_hrc_alt;
	public String imperative_hc;
	public String imperative_hyc;
	public String imperative_hyc_alt;
	public String imperative_hssoc;
	public String assert_hrc;
	public String assert_hc;
	public String assert_hyc;
	public String assert_hssoc;
	public String realize_hc; // not in wiktionary
	public String realize_hc_alt; // only 이다
	public String realize_hyc; // not in wiktionary
	public String realize_hyc_alt; // only 이다
	public String realize_hc_past; // not in wiktionary
	public String realize_hyc_past; // not in wiktionary
	public String realize_assert_hc; // not in wiktionary
	public String realize_assert_hyc; // not in wiktionary
	
	// non honorific
	// connective forms
	public String cause_hrc;
	public String cause_hc;
	public String cause_hc_alt;
	public String cause_hyc;
	public String cause_hssoc;
	public String contrast_hrc;
	public String contrast_hc;
	public String contrast_hyc;
	public String conjunction;
	public String condition_hc;
	public String condition_hc_alt;
	public String condition_hrc;
	public String motive;
	
	// non honorific
	// noun and determiner forms
	public String vn_um;
	public String vn_gi;
	public String vn_um_past;
	public String vn_um_past_alt;
	public String vn_gi_past;
	public String vn_gi_past_alt;
	public String determ_past;
	public String determ_pres;
	public String determ_fut;
	
	// honorific
	// sentence-final forms
	public String hon_ind_hrc;
	public String hon_ind_hrc_past;
	public String hon_ind_hc;
	public String hon_ind_hc_past;
	public String hon_ind_hyc;
	public String hon_ind_hyc_alt;
	public String hon_ind_hyc_past;
	public String hon_ind_hsc;
	public String hon_ind_hsc_past;
	public String hon_interrog_hrc;
	public String hon_interrog_hrc_past;
	public String hon_interrog_hc;
	public String hon_interrog_hc_past;
	public String hon_interrog_hyc;
	public String hon_interrog_hyc_alt;
	public String hon_interrog_hyc_past;
	public String hon_interrog_hsc;
	public String hon_interrog_hsc_past;
	public String hon_imperative_hrc;
	public String hon_imperative_hc;
	public String hon_imperative_hyc;
	public String hon_imperative_hyc_alt;
	public String hon_imperative_hsc;
	public String hon_assert_hrc;
	public String hon_assert_hc;
	public String hon_assert_hyc;
	public String hon_assert_hsc;
	
	// honorific
	// connective forms
	public String hon_cause_hrc;
	public String hon_cause_hc;
	public String hon_cause_hyc;
	public String hon_cause_hsc;
	public String hon_contrast_hrc;
	public String hon_contrast_hc;
	public String hon_contrast_hyc;
	public String hon_conjunction;
	public String hon_condition_hc;
	public String hon_condition_hrc;
	public String hon_motive;
	
	// honorific
	// noun and determiner forms
	public String hon_vn_um;
	public String hon_vn_gi;
	public String hon_vn_um_past;
	public String hon_vn_gi_past;
	public String hon_determ_past;
	public String hon_determ_pres;
	public String hon_determ_fut;
	
	public Forms() {
		
		this.word = "";
	}
	
	public Forms(String word) {
		
		this.word = word;
	}

	@Override
	public String toString() {
		return "\nConjugation of " + (word != null ? word + ", " : "") + (lemma != null ? "lemma=" + lemma : "")
				+ "\n\nSentence-final forms\n"
				+ (ind_hrc != null ? "ind_hrc=" + ind_hrc + ", " : "")
				+ (ind_hrc_past != null ? "ind_hrc_past=" + ind_hrc_past + ", " : "")
				+ (ind_hrc_past_alt != null ? "ind_hrc_past_alt=" + ind_hrc_past_alt + ", " : "")
				+ (ind_hc != null ? "ind_hc=" + ind_hc + ", " : "")
				+ (ind_hc_past != null ? "ind_hc_past=" + ind_hc_past + ", " : "")
				+ (ind_hc_past_alt != null ? "ind_hc_past_alt=" + ind_hc_past_alt + ", " : "")
				+ (ind_hyc != null ? "ind_hyc=" + ind_hyc + ", " : "")
				+ (ind_hyc_alt != null ? "ind_hyc_alt=" + ind_hyc_alt + ", " : "")
				+ (ind_hyc_past != null ? "ind_hyc_past=" + ind_hyc_past + ", " : "")
				+ (ind_hyc_past_alt != null ? "ind_hyc_past_alt=" + ind_hyc_past_alt + ", " : "")
				+ (ind_hssoc != null ? "ind_hssoc=" + ind_hssoc + ", " : "")
				+ (ind_hssoc_past != null ? "ind_hssoc_past=" + ind_hssoc_past + ", " : "")
				+ (ind_hssoc_past_alt != null ? "ind_hssoc_past_alt=" + ind_hssoc_past_alt + ", " : "")
				+ (interrog_hrc != null ? "interrog_hrc=" + interrog_hrc + ", " : "")
				+ (interrog_hrc_past != null ? "interrog_hrc_past=" + interrog_hrc_past + ", " : "")
				+ (interrog_hrc_past_alt != null ? "interrog_hrc_past_alt=" + interrog_hrc_past_alt + ", " : "")
				+ (interrog_hc != null ? "interrog_hc=" + interrog_hc + ", " : "")
				+ (interrog_hc_past != null ? "interrog_hc_past=" + interrog_hc_past + ", " : "")
				+ (interrog_hc_past_alt != null ? "interrog_hc_past_alt=" + interrog_hc_past_alt + ", " : "")
				+ (interrog_hyc != null ? "interrog_hyc=" + interrog_hyc + ", " : "")
				+ (interrog_hyc_alt != null ? "interrog_hyc_alt=" + interrog_hyc_alt + ", " : "")
				+ (interrog_hyc_past != null ? "interrog_hyc_past=" + interrog_hyc_past + ", " : "")
				+ (interrog_hyc_past_alt != null ? "interrog_hyc_past_alt=" + interrog_hyc_past_alt + ", " : "")
				+ (interrog_hssoc != null ? "interrog_hssoc=" + interrog_hssoc + ", " : "")
				+ (interrog_hssoc_past != null ? "interrog_hssoc_past=" + interrog_hssoc_past + ", " : "")
				+ (interrog_hssoc_past_alt != null ? "interrog_hssoc_past_alt=" + interrog_hssoc_past_alt + ", " : "")
				+ (hortative_hrc != null ? "hortative_hrc=" + hortative_hrc + ", " : "")
				+ (hortative_hc != null ? "hortative_hc=" + hortative_hc + ", " : "")
				+ (hortative_hyc != null ? "hortative_hyc=" + hortative_hyc + ", " : "")
				+ (hortative_hyc_alt != null ? "hortative_hyc_alt=" + hortative_hyc_alt + ", " : "")
				+ (hortative_hssoc != null ? "hortative_hssoc=" + hortative_hssoc + ", " : "")
				+ (imperative_hrc != null ? "imperative_hrc=" + imperative_hrc + ", " : "")
				+ (imperative_hrc_alt != null ? "imperative_hrc_alt=" + imperative_hrc_alt + ", " : "")
				+ (imperative_hc != null ? "imperative_hc=" + imperative_hc + ", " : "")
				+ (imperative_hyc != null ? "imperative_hyc=" + imperative_hyc + ", " : "")
				+ (imperative_hyc_alt != null ? "imperative_hyc_alt=" + imperative_hyc_alt + ", " : "")
				+ (imperative_hssoc != null ? "imperative_hssoc=" + imperative_hssoc + ", " : "")
				+ (assert_hrc != null ? "assert_hrc=" + assert_hrc + ", " : "")
				+ (assert_hc != null ? "assert_hc=" + assert_hc + ", " : "")
				+ (assert_hyc != null ? "assert_hyc=" + assert_hyc + ", " : "")
				+ (assert_hssoc != null ? "assert_hssoc=" + assert_hssoc + ", " : "")
				+ (realize_hc != null ? "realize_hc=" + realize_hc + ", " : "")
				+ (realize_hc_alt != null ? "realize_hc_alt=" + realize_hc_alt + ", " : "")
				+ (realize_hyc != null ? "realize_hyc=" + realize_hyc + ", " : "")
				+ (realize_hyc_alt != null ? "realize_hyc_alt=" + realize_hyc_alt + ", " : "")
				+ (realize_hc_past != null ? "realize_hc_past=" + realize_hc_past + ", " : "")
				+ (realize_hyc_past != null ? "realize_hyc_past=" + realize_hyc_past + ", " : "")
				+ (realize_assert_hc != null ? "realize_assert_hc=" + realize_assert_hc + ", " : "")
				+ (realize_assert_hyc != null ? "realize_assert_hyc=" + realize_assert_hyc : "")
				+ "\n\nConnective forms\n"
				+ (cause_hrc != null ? "cause_hrc=" + cause_hrc + ", " : "")
				+ (cause_hc != null ? "cause_hc=" + cause_hc + ", " : "")
				+ (cause_hc_alt != null ? "cause_hc_alt=" + cause_hc_alt + ", " : "")
				+ (cause_hyc != null ? "cause_hyc=" + cause_hyc + ", " : "")
				+ (cause_hssoc != null ? "cause_hssoc=" + cause_hssoc + ", " : "")
				+ (contrast_hrc != null ? "contrast_hrc=" + contrast_hrc + ", " : "")
				+ (contrast_hc != null ? "contrast_hc=" + contrast_hc + ", " : "")
				+ (contrast_hyc != null ? "contrast_hyc=" + contrast_hyc + ", " : "")
				+ (conjunction != null ? "conjunction=" + conjunction + ", " : "")
				+ (condition_hc != null ? "condition_hc=" + condition_hc + ", " : "")
				+ (condition_hc_alt != null ? "condition_hc_alt=" + condition_hc_alt + ", " : "")
				+ (condition_hrc != null ? "condition_hrc=" + condition_hrc + ", " : "")
				+ (motive != null ? "motive=" + motive : "")
				+ "\n\nNoun and determiner forms\n"
				+ (vn_um != null ? "vn_um=" + vn_um + ", " : "")
				+ (vn_gi != null ? "vn_gi=" + vn_gi + ", " : "")
				+ (vn_um_past != null ? "vn_um_past=" + vn_um_past + ", " : "")
				+ (vn_um_past_alt != null ? "vn_um_past_alt=" + vn_um_past_alt + ", " : "")
				+ (vn_gi_past != null ? "vn_gi_past=" + vn_gi_past + ", " : "")
				+ (vn_gi_past_alt != null ? "vn_gi_past_alt=" + vn_gi_past_alt + ", " : "")
				+ (determ_past != null ? "determ_past=" + determ_past + ", " : "")
				+ (determ_pres != null ? "determ_pres=" + determ_pres + ", " : "")
				+ (determ_fut != null ? "determ_fut=" + determ_fut : "")
				+ "\n\nSentence-final forms with honorific\n"
				+ (hon_ind_hrc != null ? "hon_ind_hrc=" + hon_ind_hrc + ", " : "")
				+ (hon_ind_hrc_past != null ? "hon_ind_hrc_past=" + hon_ind_hrc_past + ", " : "")
				+ (hon_ind_hc != null ? "hon_ind_hc=" + hon_ind_hc + ", " : "")
				+ (hon_ind_hc_past != null ? "hon_ind_hc_past=" + hon_ind_hc_past + ", " : "")
				+ (hon_ind_hyc != null ? "hon_ind_hyc=" + hon_ind_hyc + ", " : "")
				+ (hon_ind_hyc_alt != null ? "hon_ind_hyc_alt=" + hon_ind_hyc_alt + ", " : "")
				+ (hon_ind_hyc_past != null ? "hon_ind_hyc_past=" + hon_ind_hyc_past + ", " : "")
				+ (hon_ind_hsc != null ? "hon_ind_hsc=" + hon_ind_hsc + ", " : "")
				+ (hon_ind_hsc_past != null ? "hon_ind_hsc_past=" + hon_ind_hsc_past + ", " : "")
				+ (hon_interrog_hrc != null ? "hon_interrog_hrc=" + hon_interrog_hrc + ", " : "")
				+ (hon_interrog_hrc_past != null ? "hon_interrog_hrc_past=" + hon_interrog_hrc_past + ", " : "")
				+ (hon_interrog_hc != null ? "hon_interrog_hc=" + hon_interrog_hc + ", " : "")
				+ (hon_interrog_hc_past != null ? "hon_interrog_hc_past=" + hon_interrog_hc_past + ", " : "")
				+ (hon_interrog_hyc != null ? "hon_interrog_hyc=" + hon_interrog_hyc + ", " : "")
				+ (hon_interrog_hyc_alt != null ? "hon_interrog_hyc_alt=" + hon_interrog_hyc_alt + ", " : "")
				+ (hon_interrog_hyc_past != null ? "hon_interrog_hyc_past=" + hon_interrog_hyc_past + ", " : "")
				+ (hon_interrog_hsc != null ? "hon_interrog_hsc=" + hon_interrog_hsc + ", " : "")
				+ (hon_interrog_hsc_past != null ? "hon_interrog_hsc_past=" + hon_interrog_hsc_past + ", " : "")
				+ (hon_imperative_hrc != null ? "hon_imperative_hrc=" + hon_imperative_hrc + ", " : "")
				+ (hon_imperative_hc != null ? "hon_imperative_hc=" + hon_imperative_hc + ", " : "")
				+ (hon_imperative_hyc != null ? "hon_imperative_hyc=" + hon_imperative_hyc + ", " : "")
				+ (hon_imperative_hyc_alt != null ? "hon_imperative_hyc_alt=" + hon_imperative_hyc_alt + ", " : "")
				+ (hon_imperative_hsc != null ? "hon_imperative_hsc=" + hon_imperative_hsc + ", " : "")
				+ (hon_assert_hrc != null ? "hon_assert_hrc=" + hon_assert_hrc + ", " : "")
				+ (hon_assert_hc != null ? "hon_assert_hc=" + hon_assert_hc + ", " : "")
				+ (hon_assert_hyc != null ? "hon_assert_hyc=" + hon_assert_hyc + ", " : "")
				+ (hon_assert_hsc != null ? "hon_assert_hsc=" + hon_assert_hsc : "")
				+ "\n\nConnective forms with honorific\n"
				+ (hon_cause_hrc != null ? "hon_cause_hrc=" + hon_cause_hrc + ", " : "")
				+ (hon_cause_hc != null ? "hon_cause_hc=" + hon_cause_hc + ", " : "")
				+ (hon_cause_hyc != null ? "hon_cause_hyc=" + hon_cause_hyc + ", " : "")
				+ (hon_cause_hsc != null ? "hon_cause_hsc=" + hon_cause_hsc + ", " : "")
				+ (hon_contrast_hrc != null ? "hon_contrast_hrc=" + hon_contrast_hrc + ", " : "")
				+ (hon_contrast_hc != null ? "hon_contrast_hc=" + hon_contrast_hc + ", " : "")
				+ (hon_contrast_hyc != null ? "hon_contrast_hyc=" + hon_contrast_hyc + ", " : "")
				+ (hon_conjunction != null ? "hon_conjunction=" + hon_conjunction + ", " : "")
				+ (hon_condition_hc != null ? "hon_condition_hc=" + hon_condition_hc + ", " : "")
				+ (hon_condition_hrc != null ? "hon_condition_hrc=" + hon_condition_hrc + ", " : "")
				+ (hon_motive != null ? "hon_motive=" + hon_motive : "")
				+ "\n\nNoun and determiner forms with honorific\n"
				+ (hon_vn_um != null ? "hon_vn_um=" + hon_vn_um + ", " : "")
				+ (hon_vn_gi != null ? "hon_vn_gi=" + hon_vn_gi + ", " : "")
				+ (hon_vn_um_past != null ? "hon_vn_um_past=" + hon_vn_um_past + ", " : "")
				+ (hon_vn_gi_past != null ? "hon_vn_gi_past=" + hon_vn_gi_past + ", " : "")
				+ (hon_determ_past != null ? "hon_determ_past=" + hon_determ_past + ", " : "")
				+ (hon_determ_pres != null ? "hon_determ_pres=" + hon_determ_pres + ", " : "")
				+ (hon_determ_fut != null ? "hon_determ_fut=" + hon_determ_fut : "") + "\n";
	}

}
