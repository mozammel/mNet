package org.jugbd.mnet.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by A N M Bazlur Rahman
 *
 * @since 9/21/14.
 */
public class Attachment extends Persistence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String fileName;

    @NotNull
    private String mimeType;

    @Lob
    @Column(length = 3145728, nullable = false) // 3 MB
    private byte[] data;

    @Column(length = 3000)
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
