package hu.rendszerfejlesztes.konyvtar.model.entity.library;

public enum Language {

    angol("angol"),
    bolgar("bolgár"),
    cigany("cigány"),
    cseh("cseh"),
    eszperanto("eszperantó"),
    eszt("észt"),
    finn("finn"),
    francia("francia"),
    galego("galego"),
    gorog("görög"),
    holland("holland"),
    horvat("horvát"),
    heber("héber"),
    indonez("indonéz"),
    jiddis("jiddis"),
    katalan("katalán"),
    latin("latin"),
    lengyel("lengyel"),
    magyar("magyar"),
    norveg("norvég"),
    nemet("német"),
    olasz("olasz"),
    orosz("orosz"),
    ormeny("örmény"),
    portugal("portugál"),
    roman("román"),
    spanyol("spanyol"),
    sved("svéd"),
    szerb("szerb"),
    szlovak("szlovák"),
    tobbnyelvu("többnyelvű"),
    ukran("ukrán");

    private String value;

    Language(String language) {
        this.value = language;
    }

	public String getValue() {
		return value;
	}


    
}
