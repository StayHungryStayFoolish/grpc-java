package io.stayhungrystayfoolish.github.grpcjava.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 5:26 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Table
@Entity(name = "article")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Article extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "dict_id", nullable = false)
    private Long dictId;

    @NotNull
    @Column(name = "unique_id", nullable = false)
    private String uniqueId;

    @NotNull
    @Size(max = 800)
    @Column(name = "title", length = 800, nullable = false)
    private String title;

    @Lob
    @Column(name = "text")
    private String text;

    @NotNull
    @Size(max = 6)
    @Column(name = "language", length = 5, nullable = false)
    private String language;

    @NotNull
    @Column(name = "display", nullable = false)
    private Boolean display;

    @Size(max = 800)
    @Column(name = "icon", length = 800)
    private String icon;

    @Size(max = 800)
    @Column(name = "thumbnail", length = 800)
    private String thumbnail;

    @Size(max = 800)
    @Column(name = "tag", length = 800)
    private String tag;

    @Size(max = 3)
    @Column(name = "ordinal", length = 3)
    private Integer ordinal;

    @Size(max = 800)
    @Column(name = "status", length = 800)
    private String status;

    @Lob
    @Column(name = "extension")
    private String extension;

    @Lob
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", dictId=" + dictId +
                ", uniqueId='" + uniqueId + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", language='" + language + '\'' +
                ", display=" + display +
                ", icon='" + icon + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", tag='" + tag + '\'' +
                ", ordinal=" + ordinal +
                ", status='" + status + '\'' +
                ", extension='" + extension + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
