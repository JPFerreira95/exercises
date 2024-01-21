package banking;

import java.util.Objects;

public class Company extends AccountHolder {
	private String companyName;

	public Company(String companyName, int taxId) {
		super(taxId);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Company company = (Company) o;
		return Objects.equals(companyName, company.companyName);
	}

}
