package hu.rendszerfejlesztes.konyvtar.model.entity.library;

import lombok.Getter;

@Getter
public enum Language {

    ANGOL("angol"),
    BOLGAR("bolgár"),
    CIGANY("cigány"),
    CSEH("cseh"),
    ESZPERANTO("eszperantó"),
    ESZT("észt"),
    FINN("finn"),
    FRANCIA("francia"),
    GALEGO("galego"),
    GOROGG("görög"),
    HOLLAND("holland"),
    HORVAT("horvát"),
    HEBER("héber"),
    INDONEZ("indonéz"),
    JIDDIS("jiddis"),
    KATALAN("katalán"),
    LATIN("latin"),
    LENGYEL("lengyel"),
    MAGYAR("magyar"),
    NORVEG("norvég"),
    NEMET("német"),
    OLASZ("olasz"),
    OROSZ("orosz"),
    ORMENY("örmény"),
    PORTUGAL("portugál"),
    ROMAN("román"),
    SPANYOL("spanyol"),
    SVED("svéd"),
    SZERB("szerb"),
    SZLOVAK("szlovák"),
    TOBBNYELVU("többnyelvű"),
    UKRAN("ukrán");

    private String language;

    Language(String language) {
        this.language = language;
    }
}
