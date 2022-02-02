package com.brianb12321.fortunecookie.models;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Fortune")
@Table()
public class FortuneModel implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long fortuneId;
    private boolean isMisfortune;
    private String fortuneText;

    public FortuneModel() {
    }

    public FortuneModel(boolean isMisfortune, String fortuneText) {
        this.isMisfortune = isMisfortune;
        this.fortuneText = fortuneText;
    }

    public FortuneModel(long fortuneId, boolean isMisfortune, String fortuneText) {
        this.fortuneId = fortuneId;
        this.isMisfortune = isMisfortune;
        this.fortuneText = fortuneText;
    }

    public long getFortuneId() {
        return fortuneId;
    }

    public boolean isMisfortune() {
        return isMisfortune;
    }

    public String getFortuneText() {
        return fortuneText;
    }

    public void setFortuneId(long fortuneId) {
        this.fortuneId = fortuneId;
    }

    public void setMisfortune(boolean misfortune) {
        isMisfortune = misfortune;
    }

    public void setFortuneText(String fortuneText) {
        this.fortuneText = fortuneText;
    }
}