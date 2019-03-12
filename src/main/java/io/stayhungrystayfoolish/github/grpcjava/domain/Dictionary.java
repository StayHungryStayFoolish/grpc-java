package io.stayhungrystayfoolish.github.grpcjava.domain;

import io.stayhungrystayfoolish.github.grpcjava.grpc.Information;
import net.badata.protobuf.converter.annotation.ProtoClass;
import net.badata.protobuf.converter.annotation.ProtoField;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/11 4:39 PM
 *
 * @Description: Dictionary
 * @Version: 1.0
 */
@ProtoClass(Information.DictionaryResponse.class)
@Entity
@Table(name = "dictionary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dictionary extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ProtoField
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ProtoField
    @NotNull
    @Column(name = "parent", nullable = false)
    private String parent;

    @ProtoField
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @ProtoField
    @NotNull
    @Size(max = 5)
    @Column(name = "language", length = 5, nullable = false)
    private String language;

    @ProtoField
    @NotNull
    @Column(name = "display", nullable = false)
    private Boolean display;

    @ProtoField
    @Size(max = 800)
    @Column(name = "icon", length = 800)
    private String icon;

    @ProtoField
    @Size(max = 800)
    @Column(name = "url", length = 800)
    private String url;

    @ProtoField
    @Size(max = 800)
    @Column(name = "links", length = 800)
    private String links;

    @ProtoField
    @Size(max = 3)
    @Column(name = "ordinal", length = 3)
    private Integer ordinal;

    @ProtoField
    @Size(max = 800)
    @Column(name = "status", length = 800)
    private String status;

    @ProtoField
    @Lob
    @Column(name = "extension")
    private String extension;

    @ProtoField
    @Lob
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
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
        return "Dictionary{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", display=" + display +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", links='" + links + '\'' +
                ", ordinal=" + ordinal +
                ", status='" + status + '\'' +
                ", extension='" + extension + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
