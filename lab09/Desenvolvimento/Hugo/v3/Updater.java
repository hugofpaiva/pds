package lab09.v3;

abstract class Updater {
	private Updater successor = null;

	public void update(Smartphone phone) {
		if (successor != null)
			successor.update(phone);
		else
			System.out.println("No update for the Smartphone of " + phone.owner + " on "+ phone.version + " version.");
	}

	protected boolean canUpdate(Smartphone phone, Versions version) {
		return (phone != null) && (version != null) && (phone.version == version);
	}

	public Updater setSuccessor(Updater successor) {
		this.successor = successor;
		return this;
	}

};


class MarshmallowUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Marshmallow))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Marshmallow version.");
		else
			super.update(phone);
	}
};

class NougatUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Nougat))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Nougat version.");
		else
			super.update(phone);
	}
};

class OreoUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Oreo))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Oreo version.");
		else
			super.update(phone);
	}
};

class PieUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Pie))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Pie version.");
		else
			super.update(phone);
	}
};

class TenUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Ten))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Ten version.");
		else
			super.update(phone);
	}
};

class ElevenUpdater extends Updater {
	@Override
	public void update(Smartphone phone) {
		if (canUpdate(phone, Versions.Eleven))
			System.out.println("Updating Smartphone of "+ phone.owner + " on Eleven version.");
		else
			super.update(phone);
	}
};
