package org.isf.hl7.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "HL7")
public class HL7 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HL7_ID")
	private int hl7Id;

	@NotNull
	@Column(name = "HL7_DATE")            // SQL type: timestamp
	private LocalDateTime hl7Date;

	@NotNull
	@Column(name = "HL7_MESSAGE")
	private String hl7Message;

	@Transient
	private volatile int hashCode = 0;

	public HL7() {
	}

	public HL7(LocalDateTime hl7Date, String hl7Message) {
		this.hl7Date = hl7Date;
		this.hl7Message = hl7Message;
	}

	public LocalDateTime getHl7Date() {
		return hl7Date;
	}

	public void setHl7Date(LocalDateTime hl7Date) {
		this.hl7Date = hl7Date;
	}

	public String getHl7Message() {
		return hl7Message;
	}

	public void setHl7Message(String hl7Message) {
		this.hl7Message = hl7Message;
	}

	public int getHl7Id() {
		return hl7Id;
	}

	public void setHl7Id(int hl7Id) {
		this.hl7Id = hl7Id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		HL7 hl7 = (HL7) o;

		return new EqualsBuilder().append(hl7Id, hl7.hl7Id).append(hashCode, hl7.hashCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(hl7Id).toHashCode();
	}
}
