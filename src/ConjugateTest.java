import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConjugateTest {
	
	private static Forms forms1;
	private static Forms forms2;
	private static Forms forms3;
	private static Forms forms4;
	private static Forms forms5;
	private static Forms forms6;
	private static Forms forms7;
	private static Forms forms8;
	//private static Forms forms9;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		forms1 = Conjugate.conjugate("이다", "A", true, false, true, true, true, true);
		forms2 = Conjugate.conjugate("트이다", "A", false, false, true, true, true, true);
		forms3 = Conjugate.conjugate("하다", "V", false, false, true, true, true, true);
		forms4 = Conjugate.conjugate("모르다", "V", false, false, true, false, false, true); // irregular 르 verb
		forms5 = Conjugate.conjugate("어렵다", "A", true, false, true, true, true, true); // irregular ㅂ verb
		forms6 = Conjugate.conjugate("괜찮다", "A", false, false, true, true, true, true); // regular ㅎ verb
		forms7 = Conjugate.conjugate("그렇다", "A", true, false, true, true, true, true); // irregular ㅎ verb
		forms8 = Conjugate.conjugate("짓다", "V", true, false, true, true, true, true); // irregular ㅅ verb
		//forms9 = Conjugate.conjugate("", pos, irreg, imperative);
	}

	/**
	 * Tests of 이다 sentence-final forms
	 */
	@Test
	public void test1a() {
		assertTrue(forms1.ind_hrc.equals("이다"));
	}
	
	@Test
	public void test1b() {
		assertTrue(forms1.ind_hc.equals("이야"));
	}
	
	@Test
	public void test1c() {
		assertTrue(forms1.ind_hyc.equals("이에요"));
	}
	
	@Test
	public void test1d() {
		assertTrue(forms1.ind_hyc_alt.equals("예요"));
	}
	
	@Test
	public void test1e() {
		assertTrue(forms1.ind_hssoc.equals("입니다"));
	}
	
	@Test
	public void test1f() {
		assertTrue(forms1.ind_hrc_past.equals("이었다"));
	}
	
	@Test
	public void test1g() {
		assertTrue(forms1.ind_hrc_past_alt.equals("였다"));
	}
	
	@Test
	public void test1h() {
		assertTrue(forms1.ind_hc_past.equals("이었어"));
	}
	
	@Test
	public void test1i() {
		assertTrue(forms1.ind_hc_past_alt.equals("였어"));
	}
	
	@Test
	public void test1j() {
		assertTrue(forms1.ind_hyc_past.equals("이었어요"));
	}
	
	@Test
	public void test1k() {
		assertTrue(forms1.ind_hyc_past_alt.equals("였어요"));
	}
	
	@Test
	public void test1l() {
		assertTrue(forms1.ind_hssoc_past.equals("이었습니다"));
	}
	
	@Test
	public void test1m() {
		assertTrue(forms1.ind_hssoc_past_alt.equals("였습니다"));
	}
	
	@Test
	public void test1n() {
		assertTrue(forms1.interrog_hrc.equals("이냐"));
	}
	
	@Test
	public void test1o() {
		assertTrue(forms1.interrog_hc.equals("이야"));
	}
	
	@Test
	public void test1p() {
		assertTrue(forms1.interrog_hyc.equals("이에요"));
	}
	
	@Test
	public void test1q() {
		assertTrue(forms1.interrog_hyc_alt.equals("예요"));
	}
	
	@Test
	public void test1r() {
		assertTrue(forms1.interrog_hssoc.equals("입니까"));
	}
	
	@Test
	public void test1s() {
		assertTrue(forms1.interrog_hrc_past.equals("이었느냐"));
	}
	
	@Test
	public void test1t() {
		assertTrue(forms1.interrog_hrc_past_alt.equals("였느냐"));
	}
	
	@Test
	public void test1u() {
		assertTrue(forms1.interrog_hc_past.equals("이었어"));
	}
	
	@Test
	public void test1v() {
		assertTrue(forms1.interrog_hc_past_alt.equals("였어"));
	}
	
	@Test
	public void test1w() {
		assertTrue(forms1.interrog_hyc_past.equals("이었어요"));
	}
	
	@Test
	public void test1x() {
		assertTrue(forms1.interrog_hyc_past_alt.equals("였어요"));
	}
	
	@Test
	public void test1y() {
		assertTrue(forms1.interrog_hssoc_past.equals("이었습니까"));
	}
	
	@Test
	public void test1z() {
		assertTrue(forms1.interrog_hssoc_past_alt.equals("였습니까"));
	}
	
	@Test
	public void test1aa() {
		assertTrue(forms1.assert_hrc.equals("이겠다"));
	}
	
	@Test
	public void test1ab() {
		assertTrue(forms1.assert_hc.equals("이겠어"));
	}
	
	@Test
	public void test1ac() {
		assertTrue(forms1.assert_hyc.equals("이겠어요"));
	}
	
	@Test
	public void test1ad() {
		assertTrue(forms1.assert_hssoc.equals("이겠습니다"));
	}
	
	@Test
	public void test1ada() {
		assertTrue(forms1.realize_hc.equals("이구나"));
	}
	
	@Test
	public void test1adb() {
		assertTrue(forms1.realize_hc_alt.equals("구나"));
	}
	
	@Test
	public void test1adc() {
		assertTrue(forms1.realize_hyc.equals("이군요"));
	}
	
	@Test
	public void test1add() {
		assertTrue(forms1.realize_hyc_alt.equals("군요"));
	}
	
	/**
	 * Tests of 이다 connective forms
	 */
	@Test
	public void test1ae() {
		assertTrue(forms1.cause_hrc.equals("이에"));
	}
	
	@Test
	public void test1af() {
		assertTrue(forms1.cause_hc.equals("이어서"));
	}
	
	@Test
	public void test1ag() {
		assertTrue(forms1.cause_hyc.equals("이니"));
	}
	
	@Test
	public void test1ah() {
		assertTrue(forms1.cause_hssoc.equals("이니까"));
	}
	
	@Test
	public void test1ai() {
		assertTrue(forms1.contrast_hrc.equals("이지만"));
	}
	
	@Test
	public void test1aj() {
		assertTrue(forms1.contrast_hc.equals("인데"));
	}
	
	@Test
	public void test1ak() {
		assertTrue(forms1.contrast_hyc.equals("이더니"));
	}
	
	@Test
	public void test1al() {
		assertTrue(forms1.conjunction.equals("이고"));
	}
	
	@Test
	public void test1am() {
		assertTrue(forms1.condition_hrc.equals("이면"));
	}
	
	@Test
	public void test1an() {
		assertTrue(forms1.condition_hc.equals("이어야"));
	}
	
	/**
	 * Tests of 이다 noun and determiner forms
	 */
	@Test
	public void test1ao() {
		assertTrue(forms1.vn_um.equals("임"));
	}
	
	@Test
	public void test1ap() {
		assertTrue(forms1.vn_gi.equals("이기"));
	}
	
	@Test
	public void test1aq() {
		assertTrue(forms1.vn_um_past.equals("이었음"));
	}
	
	@Test
	public void test1ar() {
		assertTrue(forms1.vn_um_past_alt.equals("였음"));
	}
	
	@Test
	public void test1as() {
		assertTrue(forms1.vn_gi_past.equals("이었기"));
	}
	
	@Test
	public void test1at() {
		assertTrue(forms1.vn_gi_past_alt.equals("였기"));
	}
	
	@Test
	public void test1au() {
		assertTrue(forms1.determ_pres.equals("인"));
	}
	
	@Test
	public void test1av() {
		assertTrue(forms1.determ_fut.equals("일"));
	}
	
	@Test
	public void test1aw() {
		assertNull(forms1.determ_past);
	}
	
	/**
	 * Tests of 이다 sentence-final forms with honorific
	 */
	@Test
	public void test1ax() {
		assertTrue(forms1.hon_ind_hrc.equals("이시다"));
	}
	
	@Test
	public void test1ay() {
		assertTrue(forms1.hon_ind_hc.equals("이셔"));
	}
	
	@Test
	public void test1az() {
		assertTrue(forms1.hon_ind_hyc.equals("이세요"));
	}
	
	@Test
	public void test1ba() {
		assertTrue(forms1.hon_ind_hyc_alt.equals("이셔요"));
	}
	
	@Test
	public void test1bb() {
		assertTrue(forms1.hon_ind_hsc.equals("이십니다"));
	}
	
	@Test
	public void test1bc() {
		assertTrue(forms1.hon_ind_hrc_past.equals("이셨다"));
	}
	
	@Test
	public void test1bd() {
		assertTrue(forms1.hon_ind_hc_past.equals("이셨어"));
	}
	
	@Test
	public void test1be() {
		assertTrue(forms1.hon_ind_hyc_past.equals("이셨어요"));
	}
	
	@Test
	public void test1bf() {
		assertTrue(forms1.hon_ind_hsc_past.equals("이셨습니다"));
	}
	
	@Test
	public void test1bg() {
		assertTrue(forms1.hon_interrog_hrc.equals("이시냐"));
	}
	
	@Test
	public void test1bh() {
		assertTrue(forms1.hon_interrog_hc.equals("이셔"));
	}
	
	@Test
	public void test1bi() {
		assertTrue(forms1.hon_interrog_hyc.equals("이세요"));
	}
	
	@Test
	public void test1bj() {
		assertTrue(forms1.hon_interrog_hyc_alt.equals("이셔요"));
	}
	
	@Test
	public void test1bk() {
		assertTrue(forms1.hon_interrog_hsc.equals("이십니까"));
	}
	
	@Test
	public void test1bl() {
		assertTrue(forms1.hon_interrog_hrc_past.equals("이셨냐"));
	}
	
	@Test
	public void test1bm() {
		assertTrue(forms1.hon_interrog_hc_past.equals("이셨어"));
	}
	
	@Test
	public void test1bn() {
		assertTrue(forms1.hon_interrog_hyc_past.equals("이셨어요"));
	}
	
	@Test
	public void test1bo() {
		assertTrue(forms1.hon_interrog_hsc_past.equals("이셨습니까"));
	}
	
	@Test
	public void test1bp() {
		assertTrue(forms1.hon_assert_hrc.equals("이시겠다"));
	}
	
	@Test
	public void test1bq() {
		assertTrue(forms1.hon_assert_hc.equals("이시겠어"));
	}
	
	@Test
	public void test1br() {
		assertTrue(forms1.hon_assert_hyc.equals("이시겠어요"));
	}
	
	@Test
	public void test1bs() {
		assertTrue(forms1.hon_assert_hsc.equals("이시겠습니다"));
	}
	
	/**
	 * Tests of 이다 connective forms with honorific
	 */
	@Test
	public void test1bt() {
		assertTrue(forms1.hon_cause_hrc.equals("이셔"));
	}
	
	@Test
	public void test1bu() {
		assertTrue(forms1.hon_cause_hc.equals("이셔서"));
	}
	
	@Test
	public void test1bv() {
		assertTrue(forms1.hon_cause_hyc.equals("이시니"));
	}
	
	@Test
	public void test1bw() {
		assertTrue(forms1.hon_cause_hsc.equals("이시니까"));
	}
	
	@Test
	public void test1bx() {
		assertTrue(forms1.hon_contrast_hrc.equals("이시지만"));
	}
	
	@Test
	public void test1by() {
		assertTrue(forms1.hon_contrast_hc.equals("이신데"));
	}
	
	@Test
	public void test1bz() {
		assertTrue(forms1.hon_contrast_hyc.equals("이시더니"));
	}
	
	@Test
	public void test1ca() {
		assertTrue(forms1.hon_conjunction.equals("이시고"));
	}
	
	@Test
	public void test1cb() {
		assertTrue(forms1.hon_condition_hrc.equals("이시면"));
	}
	
	@Test
	public void test1cc() {
		assertTrue(forms1.hon_condition_hc.equals("이셔야"));
	}
	
	@Test
	public void test1cd() {
		assertTrue(forms1.hon_vn_um.equals("이심"));
	}
	
	@Test
	public void test1ce() {
		assertTrue(forms1.hon_vn_gi.equals("이시기"));
	}
	
	@Test
	public void test1cf() {
		assertTrue(forms1.hon_vn_um_past.equals("이셨음"));
	}
	
	@Test
	public void test1cg() {
		assertTrue(forms1.hon_vn_gi_past.equals("이셨기"));
	}
	
	@Test
	public void test1ch() {
		assertTrue(forms1.hon_determ_pres.equals("이신"));
	}
	
	@Test
	public void test1ci() {
		assertTrue(forms1.hon_determ_fut.equals("이실"));
	}
	
	@Test
	public void test1cj() {
		assertNull(forms1.hon_determ_past);
	}
	
	/**
	 * Tests of 트이다 sentence-final forms
	 */
	@Test
	public void test2a() {
		assertTrue(forms2.ind_hrc.equals("트이다"));
	}
	
	@Test
	public void test2b() {
		assertTrue(forms2.ind_hc.equals("트여"));
	}
	
	@Test
	public void test2c() {
		assertTrue(forms2.ind_hyc.equals("트여요"));
	}
	
	@Test
	public void test2d() {
		assertTrue(forms2.ind_hyc_alt.equals("트이어요"));
	}
	
	@Test
	public void test2e() {
		assertTrue(forms2.ind_hssoc.equals("트입니다"));
	}
	
	@Test
	public void test2f() {
		assertTrue(forms2.ind_hrc_past.equals("트였다"));
	}
	
	@Test
	public void test2g() {
		assertNull(forms2.ind_hrc_past_alt);
	}
	
	@Test
	public void test2h() {
		assertTrue(forms2.ind_hc_past.equals("트였어"));
	}
	
	@Test
	public void test2i() {
		assertNull(forms2.ind_hc_past_alt);
	}
	
	@Test
	public void test2j() {
		assertTrue(forms2.ind_hyc_past.equals("트였어요"));
	}
	
	@Test
	public void test2k() {
		assertTrue(forms2.ind_hssoc_past.equals("트였습니다"));
	}
	
	@Test
	public void test2l() {
		assertTrue(forms2.interrog_hrc.equals("트이냐"));
	}
	
	@Test
	public void test2m() {
		assertTrue(forms2.interrog_hc.equals("트여"));
	}
	
	@Test
	public void test2n() {
		assertTrue(forms2.interrog_hyc.equals("트여요"));
	}
	
	@Test
	public void test2o() {
		assertTrue(forms2.interrog_hyc_alt.equals("트이어요"));
	}
	
	@Test
	public void test2p() {
		assertTrue(forms2.interrog_hssoc.equals("트입니까"));
	}
	
	@Test
	public void test2q() {
		assertTrue(forms2.interrog_hrc_past.equals("트였냐"));
	}
	
	@Test
	public void test2r() {
		assertTrue(forms2.interrog_hc_past.equals("트였어"));
	}
	
	@Test
	public void test2s() {
		assertTrue(forms2.interrog_hyc_past.equals("트였어요"));
	}
	
	@Test
	public void test2t() {
		assertTrue(forms2.interrog_hssoc_past.equals("트였습니까"));
	}
	
	@Test
	public void test2u() {
		assertTrue(forms2.assert_hrc.equals("트이겠다"));
	}
	
	@Test
	public void test2v() {
		assertTrue(forms2.assert_hc.equals("트이겠어"));
	}
	
	@Test
	public void test2w() {
		assertTrue(forms2.assert_hyc.equals("트이겠어요"));
	}
	
	@Test
	public void test2x() {
		assertTrue(forms2.assert_hssoc.equals("트이겠습니다"));
	}
	
	/**
	 * Tests of 트이다 connective forms
	 */
	@Test
	public void test2y() {
		assertTrue(forms2.cause_hrc.equals("트여"));
	}
	
	@Test
	public void test2z() {
		assertTrue(forms2.cause_hc.equals("트여서"));
	}
	
	@Test
	public void test2aa() {
		assertTrue(forms2.cause_hc_alt.equals("트이어서"));
	}
	
	@Test
	public void test2ab() {
		assertTrue(forms2.cause_hyc.equals("트이니"));
	}
	
	@Test
	public void test2ac() {
		assertTrue(forms2.cause_hssoc.equals("트이니까"));
	}
	
	@Test
	public void test2ad() {
		assertTrue(forms2.contrast_hrc.equals("트이지만"));
	}
	
	@Test
	public void test2ae() {
		assertTrue(forms2.contrast_hc.equals("트인데"));
	}
	
	@Test
	public void test2af() {
		assertTrue(forms2.contrast_hyc.equals("트이더니"));
	}
	
	@Test
	public void test2ag() {
		assertTrue(forms2.conjunction.equals("트이고"));
	}
	
	@Test
	public void test2ah() {
		assertTrue(forms2.condition_hrc.equals("트이면"));
	}
	
	@Test
	public void test2ai() {
		assertTrue(forms2.condition_hc.equals("트여야"));
	}
	
	@Test
	public void test2aj() {
		assertTrue(forms2.condition_hc_alt.equals("트이어야"));
	}
	
	/**
	 * Tests of 하다 sentence-final forms
	 */
	@Test
	public void test3a() {
		assertTrue(forms3.ind_hrc.equals("한다"));
	}
	
	@Test
	public void test3b() {
		assertTrue(forms3.ind_hc.equals("해"));
	}
	
	@Test
	public void test3c() {
		assertTrue(forms3.ind_hyc.equals("해요"));
	}
	
	@Test
	public void test3d() {
		assertTrue(forms3.ind_hssoc.equals("합니다"));
	}
	
	@Test
	public void test3e() {
		assertTrue(forms3.ind_hrc_past.equals("했다"));
	}
	
	@Test
	public void test3f() {
		assertTrue(forms3.ind_hc_past.equals("했어"));
	}
	
	@Test
	public void test3g() {
		assertNull(forms3.ind_hc_past_alt);
	}
	
	@Test
	public void test3h() {
		assertTrue(forms3.ind_hyc_past.equals("했어요"));
	}
	
	@Test
	public void test3i() {
		assertTrue(forms3.ind_hssoc_past.equals("했습니다"));
	}
	
	@Test
	public void test3j() {
		assertTrue(forms3.interrog_hrc.equals("하느냐"));
	}
	
	@Test
	public void test3k() {
		assertTrue(forms3.interrog_hc.equals("해"));
	}
	
	@Test
	public void test3l() {
		assertTrue(forms3.interrog_hyc.equals("해요"));
	}
	
	@Test
	public void test3m() {
		assertNull(forms3.interrog_hyc_alt);
	}
	
	@Test
	public void test3n() {
		assertTrue(forms3.interrog_hssoc.equals("합니까"));
	}
	
	@Test
	public void test3o() {
		assertTrue(forms3.interrog_hrc_past.equals("했느냐"));
	}
	
	@Test
	public void test3p() {
		assertTrue(forms3.interrog_hc_past.equals("했어"));
	}
	
	@Test
	public void test3q() {
		assertTrue(forms3.interrog_hyc_past.equals("했어요"));
	}
	
	@Test
	public void test3r() {
		assertTrue(forms3.interrog_hssoc_past.equals("했습니까"));
	}
	
	@Test
	public void test3s() {
		assertTrue(forms3.hortative_hrc.equals("하자"));
	}
	
	@Test
	public void test3t() {
		assertTrue(forms3.hortative_hc.equals("해"));
	}
	
	@Test
	public void test3u() {
		assertTrue(forms3.hortative_hyc.equals("해요"));
	}
	
	@Test
	public void test3v() {
		assertTrue(forms3.hortative_hssoc.equals("합시다"));
	}
	
	@Test
	public void test3w() {
		assertTrue(forms3.imperative_hrc.equals("해라"));
	}
	
	@Test
	public void test3x() {
		assertTrue(forms3.imperative_hrc_alt.equals("하여라"));
	}
	
	@Test
	public void test3y() {
		assertTrue(forms3.imperative_hc.equals("해"));
	}
	
	@Test
	public void test3z() {
		assertTrue(forms3.imperative_hyc.equals("해요"));
	}
	
	@Test
	public void test3aa() {
		assertTrue(forms3.imperative_hssoc.equals("합시오"));
	}
	
	@Test
	public void test3ab() {
		assertTrue(forms3.assert_hrc.equals("하겠다"));
	}
	
	@Test
	public void test3ac() {
		assertTrue(forms3.assert_hc.equals("하겠어"));
	}
	
	@Test
	public void test3ad() {
		assertTrue(forms3.assert_hyc.equals("하겠어요"));
	}
	
	@Test
	public void test3ae() {
		assertTrue(forms3.assert_hssoc.equals("하겠습니다"));
	}
	
	/**
	 * Tests of 하다 connective forms
	 */
	@Test
	public void test3af() {
		assertTrue(forms3.cause_hrc.equals("해"));
	}
	
	@Test
	public void test3ag() {
		assertTrue(forms3.cause_hc.equals("해서"));
	}
	
	@Test
	public void test3ah() {
		assertTrue(forms3.cause_hc_alt.equals("하여서"));
	}
	
	@Test
	public void test3ai() {
		assertTrue(forms3.cause_hyc.equals("하니"));
	}
	
	@Test
	public void test3aj() {
		assertTrue(forms3.cause_hssoc.equals("하니까"));
	}
	
	@Test
	public void test3ak() {
		assertTrue(forms3.contrast_hrc.equals("하지만"));
	}
	
	@Test
	public void test3al() {
		assertTrue(forms3.contrast_hc.equals("하는데"));
	}
	
	@Test
	public void test3am() {
		assertTrue(forms3.contrast_hyc.equals("하더니"));
	}
	
	@Test
	public void test3an() {
		assertTrue(forms3.conjunction.equals("하고"));
	}
	
	@Test
	public void test3ao() {
		assertTrue(forms3.condition_hrc.equals("하면"));
	}
	
	@Test
	public void test3ap() {
		assertTrue(forms3.condition_hc.equals("해야"));
	}
	
	@Test
	public void test3aq() {
		assertTrue(forms3.condition_hc_alt.equals("하여야"));
	}
	
	@Test
	public void test3ar() {
		assertTrue(forms3.motive.equals("하려고"));
	}
	
	/**
	 * Tests of 하다 noun and determiner forms
	 */
	@Test
	public void test3as() {
		assertTrue(forms3.vn_um.equals("함"));
	}
	
	@Test
	public void test3at() {
		assertTrue(forms3.vn_gi.equals("하기"));
	}
	
	@Test
	public void test3au() {
		assertTrue(forms3.vn_um_past.equals("했음"));
	}
	
	@Test
	public void test3av() {
		assertTrue(forms3.vn_um_past_alt.equals("하였음"));
	}
	
	@Test
	public void test3aw() {
		assertTrue(forms3.vn_gi_past.equals("했기"));
	}
	
	@Test
	public void test3ax() {
		assertTrue(forms3.vn_gi_past_alt.equals("하였기"));
	}
	
	@Test
	public void test3ay() {
		assertTrue(forms3.determ_pres.equals("하는"));
	}
	
	@Test
	public void test3az() {
		assertTrue(forms3.determ_fut.equals("할"));
	}
	
	@Test
	public void test3ba() {
		assertTrue(forms3.determ_past.equals("한"));
	}
	
	/**
	 * Tests of 하다 sentence-final forms with honorific
	 */
	@Test
	public void test3bb() {
		assertTrue(forms3.hon_ind_hrc.equals("하신다"));
	}
	
	@Test
	public void test3bc() {
		assertTrue(forms3.hon_ind_hc.equals("하셔"));
	}
	
	@Test
	public void test3bd() {
		assertTrue(forms3.hon_ind_hyc.equals("하세요"));
	}
	
	@Test
	public void test3be() {
		assertTrue(forms3.hon_ind_hyc_alt.equals("하셔요"));
	}
	
	@Test
	public void test3bf() {
		assertTrue(forms3.hon_ind_hsc.equals("하십니다"));
	}
	
	@Test
	public void test3bg() {
		assertTrue(forms3.hon_ind_hrc_past.equals("하셨다"));
	}
	
	@Test
	public void test3bh() {
		assertTrue(forms3.hon_ind_hc_past.equals("하셨어"));
	}
	
	@Test
	public void test3bi() {
		assertTrue(forms3.hon_ind_hyc_past.equals("하셨어요"));
	}
	
	@Test
	public void test3bj() {
		assertTrue(forms3.hon_ind_hsc_past.equals("하셨습니다"));
	}
	
	@Test
	public void test3bk() {
		assertTrue(forms3.hon_interrog_hrc.equals("하시느냐"));
	}
	
	@Test
	public void test3bl() {
		assertTrue(forms3.hon_interrog_hc.equals("하셔"));
	}
	
	@Test
	public void test3bm() {
		assertTrue(forms3.hon_interrog_hyc.equals("하세요"));
	}
	
	@Test
	public void test3bn() {
		assertTrue(forms3.hon_interrog_hyc_alt.equals("하셔요"));
	}
	
	@Test
	public void test3bo() {
		assertTrue(forms3.hon_interrog_hsc.equals("하십니까"));
	}
	
	@Test
	public void test3bp() {
		assertTrue(forms3.hon_interrog_hrc_past.equals("하셨느냐"));
	}
	
	@Test
	public void test3bq() {
		assertTrue(forms3.hon_interrog_hc_past.equals("하셨어"));
	}
	
	@Test
	public void test3br() {
		assertTrue(forms3.hon_interrog_hyc_past.equals("하셨어요"));
	}
	
	@Test
	public void test3bs() {
		assertTrue(forms3.hon_interrog_hsc_past.equals("하셨습니까"));
	}
	
	@Test
	public void test3bt() {
		assertTrue(forms3.hon_imperative_hrc.equals("하시라"));
	}
	
	@Test
	public void test3bu() {
		assertTrue(forms3.hon_imperative_hc.equals("하셔"));
	}
	
	@Test
	public void test3bv() {
		assertTrue(forms3.hon_imperative_hyc.equals("하세요"));
	}
	
	@Test
	public void test3bw() {
		assertTrue(forms3.hon_imperative_hsc.equals("하십시오"));
	}
	
	@Test
	public void test3bx() {
		assertTrue(forms3.hon_assert_hrc.equals("하시겠다"));
	}
	
	@Test
	public void test3by() {
		assertTrue(forms3.hon_assert_hc.equals("하시겠어"));
	}
	
	@Test
	public void test3bz() {
		assertTrue(forms3.hon_assert_hyc.equals("하시겠어요"));
	}
	
	@Test
	public void test3ca() {
		assertTrue(forms3.hon_assert_hsc.equals("하시겠습니다"));
	}
	
	/**
	 * Tests of 모르다 sentence-final forms
	 */
	@Test
	public void test4a() {
		assertTrue(forms4.ind_hrc.equals("모른다"));
	}
	
	@Test
	public void test4b() {
		assertTrue(forms4.ind_hc.equals("몰라"));
	}
	
	@Test
	public void test4c() {
		assertTrue(forms4.ind_hyc.equals("몰라요"));
	}
	
	@Test
	public void test4d() {
		assertNull(forms4.ind_hyc_alt);
	}
	
	@Test
	public void test4e() {
		assertTrue(forms4.ind_hssoc.equals("모릅니다"));
	}
	
	@Test
	public void test4f() {
		assertTrue(forms4.ind_hrc_past.equals("몰랐다"));
	}
	
	@Test
	public void test4g() {
		assertNull(forms4.ind_hrc_past_alt);
	}
	
	@Test
	public void test4h() {
		assertTrue(forms4.ind_hc_past.equals("몰랐어"));
	}
	
	@Test
	public void test4i() {
		assertTrue(forms4.ind_hyc_past.equals("몰랐어요"));
	}
	
	@Test
	public void test4j() {
		assertTrue(forms4.ind_hssoc_past.equals("몰랐습니다"));
	}
	
	@Test
	public void test4k() {
		assertTrue(forms4.interrog_hrc.equals("모르느냐"));
	}
	
	@Test
	public void test4l() {
		assertTrue(forms4.interrog_hc.equals("몰라"));
	}
	
	@Test
	public void test4m() {
		assertTrue(forms4.interrog_hyc.equals("몰라요"));
	}
	
	@Test
	public void test4n() {
		assertTrue(forms4.interrog_hssoc.equals("모릅니까"));
	}
	
	@Test
	public void test4o() {
		assertTrue(forms4.interrog_hrc_past.equals("몰랐느냐"));
	}
	
	@Test
	public void test4p() {
		assertTrue(forms4.interrog_hc_past.equals("몰랐어"));
	}
	
	@Test
	public void test4q() {
		assertTrue(forms4.interrog_hyc_past.equals("몰랐어요"));
	}
	
	@Test
	public void test4r() {
		assertTrue(forms4.interrog_hssoc_past.equals("몰랐습니까"));
	}
	
	@Test
	public void test4s() {
		assertTrue(forms4.hortative_hrc.equals("모르자"));
	}
	
	@Test
	public void test4t() {
		assertTrue(forms4.hortative_hc.equals("몰라"));
	}
	
	@Test
	public void test4u() {
		assertTrue(forms4.hortative_hyc.equals("몰라요"));
	}
	
	@Test
	public void test4v() {
		assertTrue(forms4.hortative_hssoc.equals("모릅시다"));
	}
	
	@Test
	public void test4w() {
		assertTrue(forms4.assert_hrc.equals("모르겠다"));
	}
	
	@Test
	public void test4x() {
		assertTrue(forms4.assert_hc.equals("모르겠어"));
	}
	
	@Test
	public void test4y() {
		assertTrue(forms4.assert_hyc.equals("모르겠어요"));
	}
	
	@Test
	public void test4z() {
		assertTrue(forms4.assert_hssoc.equals("모르겠습니다"));
	}
	
	/**
	 * Tests of 모르다 connective forms
	 */
	@Test
	public void test4aa() {
		assertTrue(forms4.cause_hrc.equals("몰라"));
	}
	
	@Test
	public void test4ab() {
		assertTrue(forms4.cause_hc.equals("몰라서"));
	}
	
	@Test
	public void test4ac() {
		assertNull(forms4.cause_hc_alt);
	}
	
	@Test
	public void test4ad() {
		assertTrue(forms4.cause_hyc.equals("모르니"));
	}
	
	@Test
	public void test4ae() {
		assertTrue(forms4.cause_hssoc.equals("모르니까"));
	}
	
	@Test
	public void test4af() {
		assertTrue(forms4.contrast_hrc.equals("모르지만"));
	}
	
	@Test
	public void test4ag() {
		assertTrue(forms4.contrast_hc.equals("모르는데"));
	}
	
	@Test
	public void test4ah() {
		assertTrue(forms4.contrast_hyc.equals("모르더니"));
	}
	
	@Test
	public void test4ai() {
		assertTrue(forms4.conjunction.equals("모르고"));
	}
	
	@Test
	public void test4aj() {
		assertTrue(forms4.condition_hrc.equals("모르면"));
	}
	
	@Test
	public void test4ak() {
		assertTrue(forms4.condition_hc.equals("몰라야"));
	}
	
	@Test
	public void test4al() {
		assertNull(forms4.condition_hc_alt);
	}
	
	@Test
	public void test4am() {
		assertTrue(forms4.motive.equals("모르려고"));
	}
	
	/**
	 * Tests of 모르다 noun and determiner forms
	 */
	@Test
	public void test4an() {
		assertTrue(forms4.vn_um.equals("모름"));
	}
	
	@Test
	public void test4ao() {
		assertTrue(forms4.vn_gi.equals("모르기"));
	}
	
	@Test
	public void test4ap() {
		assertTrue(forms4.vn_um_past.equals("몰랐음"));
	}
	
	@Test
	public void test4aq() {
		assertTrue(forms4.vn_gi_past.equals("몰랐기"));
	}
	
	@Test
	public void test4ar() {
		assertTrue(forms4.determ_pres.equals("모르는"));
	}
	
	@Test
	public void test4as() {
		assertTrue(forms4.determ_fut.equals("모를"));
	}
	
	@Test
	public void test4at() {
		assertTrue(forms4.determ_past.equals("모른"));
	}
	
	/**
	 * Tests of 모르다 honorific forms
	 */
	@Test
	public void test4au() {
		assertTrue(forms4.hon_ind_hrc.equals("모르신다"));
	}
	
	@Test
	public void test4av() {
		assertTrue(forms4.hon_interrog_hyc_past.equals("모르셨어요"));
	}
	
	/**
	 * Tests of 어렵다 sentence-final forms
	 */
	@Test
	public void test5a() {
		assertTrue(forms5.ind_hrc.equals("어렵다"));
	}
	
	@Test
	public void test5b() {
		assertTrue(forms5.ind_hc.equals("어려워"));
	}
	
	@Test
	public void test5c() {
		assertTrue(forms5.ind_hyc.equals("어려워요"));
	}
	
	@Test
	public void test5d() {
		assertNull(forms5.ind_hyc_alt);
	}
	
	@Test
	public void test5e() {
		assertTrue(forms5.ind_hssoc.equals("어렵습니다"));
	}
	
	@Test
	public void test5f() {
		assertTrue(forms5.ind_hrc_past.equals("어려웠다"));
	}
	
	@Test
	public void test5g() {
		assertNull(forms5.ind_hrc_past_alt);
	}
	
	@Test
	public void test5h() {
		assertTrue(forms5.ind_hc_past.equals("어려웠어"));
	}
	
	@Test
	public void test5j() {
		assertTrue(forms5.ind_hyc_past.equals("어려웠어요"));
	}
	
	@Test
	public void test5k() {
		assertTrue(forms5.ind_hssoc_past.equals("어려웠습니다"));
	}
	
	@Test
	public void test5l() {
		assertTrue(forms5.interrog_hrc.equals("어려우냐"));
	}
	
	@Test
	public void test5m() {
		assertTrue(forms5.interrog_hc.equals("어려워"));
	}
	
	@Test
	public void test5n() {
		assertTrue(forms5.interrog_hyc.equals("어려워요"));
	}
	
	@Test
	public void test5p() {
		assertTrue(forms5.interrog_hssoc.equals("어렵습니까"));
	}
	
	@Test
	public void test5q() {
		assertTrue(forms5.interrog_hrc_past.equals("어려웠냐"));
	}
	
	@Test
	public void test5r() {
		assertTrue(forms5.interrog_hc_past.equals("어려웠어"));
	}
	
	@Test
	public void test5s() {
		assertTrue(forms5.interrog_hyc_past.equals("어려웠어요"));
	}
	
	@Test
	public void test5t() {
		assertTrue(forms5.interrog_hssoc_past.equals("어려웠습니까"));
	}
	
	@Test
	public void test5u() {
		assertTrue(forms5.assert_hrc.equals("어렵겠다"));
	}
	
	@Test
	public void test5v() {
		assertTrue(forms5.assert_hc.equals("어렵겠어"));
	}
	
	@Test
	public void test5w() {
		assertTrue(forms5.assert_hyc.equals("어렵겠어요"));
	}
	
	@Test
	public void test5x() {
		assertTrue(forms5.assert_hssoc.equals("어렵겠습니다"));
	}
	
	/**
	 * Tests of 어렵다 connective forms
	 */
	@Test
	public void test5y() {
		assertTrue(forms5.cause_hrc.equals("어려워"));
	}
	
	@Test
	public void test5z() {
		assertTrue(forms5.cause_hc.equals("어려워서"));
	}
	
	@Test
	public void test5aa() {
		assertNull(forms5.cause_hc_alt);
	}
	
	@Test
	public void test5ab() {
		assertTrue(forms5.cause_hyc.equals("어려우니"));
	}
	
	@Test
	public void test5ac() {
		assertTrue(forms5.cause_hssoc.equals("어려우니까"));
	}
	
	@Test
	public void test5ad() {
		assertTrue(forms5.contrast_hrc.equals("어렵지만"));
	}
	
	@Test
	public void test5ae() {
		assertTrue(forms5.contrast_hc.equals("어려운데"));
	}
	
	@Test
	public void test5af() {
		assertTrue(forms5.contrast_hyc.equals("어렵더니"));
	}
	
	@Test
	public void test5ag() {
		assertTrue(forms5.conjunction.equals("어렵고"));
	}
	
	@Test
	public void test5ah() {
		assertTrue(forms5.condition_hrc.equals("어려우면"));
	}
	
	@Test
	public void test5ai() {
		assertTrue(forms5.condition_hc.equals("어려워야"));
	}
	
	/**
	 * Tests of 어렵다 noun and determiner forms
	 */
	@Test
	public void test5aj() {
		assertTrue(forms5.vn_um.equals("어려움"));
	}
	
	@Test
	public void test5ak() {
		assertTrue(forms5.vn_gi.equals("어렵기"));
	}
	
	@Test
	public void test5al() {
		assertTrue(forms5.vn_um_past.equals("어려웠음"));
	}
	
	@Test
	public void test5am() {
		assertTrue(forms5.vn_gi_past.equals("어려웠기"));
	}
	
	@Test
	public void test5an() {
		assertTrue(forms5.determ_pres.equals("어려운"));
	}
	
	@Test
	public void test5ao() {
		assertTrue(forms5.determ_fut.equals("어려울"));
	}
	
	@Test
	public void test5ap() {
		assertNull(forms5.determ_past);
	}
	
	/**
	 * Tests of 어렵다 honorific forms
	 */
	@Test
	public void test5aq() {
		assertTrue(forms5.hon_interrog_hyc_past.equals("어려우셨어요"));
	}
	
	@Test
	public void test5ar() {
		assertTrue(forms5.hon_contrast_hc.equals("어려우신데"));
	}
	
	/**
	 * Tests of 괜찮다 sentence-final forms
	 */
	@Test
	public void test6a() {
		assertTrue(forms6.ind_hrc.equals("괜찮다"));
	}
	
	@Test
	public void test6b() {
		assertTrue(forms6.ind_hc.equals("괜찮아"));
	}
	
	@Test
	public void test6c() {
		assertNull(forms6.ind_hyc_alt);
	}
	
	@Test
	public void test6d() {
		assertTrue(forms6.ind_hssoc.equals("괜찮습니다"));
	}
	
	@Test
	public void test6e() {
		assertTrue(forms6.ind_hrc_past.equals("괜찮았다"));
	}
	
	@Test
	public void test6f() {
		assertTrue(forms6.interrog_hrc.equals("괜찮으냐"));
	}
	
	/**
	 * Tests of 괜찮다 connective forms
	 */
	@Test
	public void test6g() {
		assertTrue(forms6.contrast_hc.equals("괜찮은데"));
	}
	
	/**
	 * Tests of 괜찮다 noun and determiner forms
	 */
	@Test
	public void test6h() {
		assertTrue(forms6.vn_um.equals("괜찮음"));
	}
	
	@Test
	public void test6i() {
		assertNull(forms6.vn_gi_past_alt);
	}
	
	@Test
	public void test6j() {
		assertTrue(forms6.determ_fut.equals("괜찮을"));
	}
	
	/**
	 * Tests of 괜찮다 honorific forms
	 */
	@Test
	public void test6k() {
		assertTrue(forms6.hon_interrog_hyc_past.equals("괜찮으셨어요"));
	}
	
	@Test
	public void test6l() {
		assertTrue(forms6.hon_contrast_hc.equals("괜찮으신데"));
	}
	
	/**
	 * Tests of 그렇다 sentence-final forms
	 */
	@Test
	public void test7a() {
		assertTrue(forms7.ind_hrc.equals("그렇다"));
	}
	
	@Test
	public void test7b() {
		assertTrue(forms7.ind_hc.equals("그래"));
	}
	
	@Test
	public void test7c() {
		assertNull(forms7.ind_hyc_alt);
	}
	
	@Test
	public void test7d() {
		assertTrue(forms7.ind_hssoc.equals("그렇습니다"));
	}
	
	@Test
	public void test7e() {
		assertTrue(forms7.ind_hrc_past.equals("그랬다"));
	}
	
	@Test
	public void test7f() {
		assertTrue(forms7.interrog_hrc.equals("그러냐"));
	}
	
	/**
	 * Tests of 그렇다 connective forms
	 */
	@Test
	public void test7g() {
		assertTrue(forms7.contrast_hc.equals("그런데"));
	}
	
	/**
	 * Tests of 그렇다 noun and determiner forms
	 */
	@Test
	public void test7h() {
		assertTrue(forms7.vn_um.equals("그럼"));
	}
	
	@Test
	public void test7i() {
		assertNull(forms7.vn_gi_past_alt);
	}
	
	@Test
	public void test7j() {
		assertTrue(forms7.determ_fut.equals("그럴"));
	}
	
	/**
	 * Tests of 그렇다 honorific forms
	 */
	@Test
	public void test7k() {
		assertTrue(forms7.hon_interrog_hyc_past.equals("그러셨어요"));
	}
	
	@Test
	public void test7l() {
		assertTrue(forms7.hon_contrast_hc.equals("그러신데"));
	}
	
	/**
	 * Tests of 짓다 sentence-final forms
	 */
	@Test
	public void test8a() {
		assertTrue(forms8.ind_hrc.equals("짓는다"));
	}
	
	@Test
	public void test8b() {
		assertTrue(forms8.ind_hc.equals("지어"));
	}
	
	@Test
	public void test8c() {
		assertNull(forms8.ind_hyc_alt);
	}
	
	@Test
	public void test8d() {
		assertTrue(forms8.ind_hssoc.equals("짓습니다"));
	}
	
	@Test
	public void test8e() {
		assertTrue(forms8.ind_hrc_past.equals("지었다"));
	}
	
	@Test
	public void test8f() {
		assertTrue(forms8.interrog_hrc.equals("짓느냐"));
	}
	
	@Test
	public void test8g() {
		assertTrue(forms8.interrog_hssoc.equals("짓습니까"));
	}
	
	@Test
	public void test8h() {
		assertNull(forms8.interrog_hyc_alt);
	}
	
	@Test
	public void test8i() {
		assertTrue(forms8.assert_hrc.equals("짓겠다"));
	}
	
	/**
	 * Tests of 짓다 connective forms
	 */
	@Test
	public void test8j() {
		assertNull(forms8.cause_hc_alt);
	}
	
	@Test
	public void test8k() {
		assertTrue(forms8.cause_hyc.equals("지으니"));
	}
	
	@Test
	public void test8l() {
		assertTrue(forms8.condition_hrc.equals("지으면"));
	}
	
	@Test
	public void test8m() {
		assertNull(forms8.condition_hc_alt);
	}
	
	@Test
	public void test8n() {
		assertTrue(forms8.motive.equals("지으려고"));
	}
	
	/**
	 * Tests of 짓다 noun and determiner forms
	 */
	@Test
	public void test8o() {
		assertTrue(forms8.vn_um.equals("지음"));
	}
	
	@Test
	public void test8p() {
		assertNull(forms8.vn_gi_past_alt);
	}
	
	@Test
	public void test8q() {
		assertTrue(forms8.determ_fut.equals("지을"));
	}
	
	@Test
	public void test8r() {
		assertTrue(forms8.determ_past.equals("지은"));
	}
	
	/**
	 * Tests of 짓다 honorific forms
	 */
	@Test
	public void test8s() {
		assertTrue(forms8.hon_interrog_hyc_past.equals("지으셨어요"));
	}
	
	@Test
	public void test8t() {
		assertTrue(forms8.hon_contrast_hc.equals("지으시는데"));
	}
}
