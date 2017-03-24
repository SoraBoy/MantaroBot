package net.kodehawa.mantarobot.utils.jda;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.requests.RestAction;

import java.util.ArrayList;
import java.util.List;

import static br.com.brjdevs.java.utils.extensions.CollectionUtils.random;

public class ShardedUser implements User {
	private final List<User> users;
	private ShardedJDA jda;

	public ShardedUser(List<User> users, ShardedJDA jda) {
		this.users = new ArrayList<>(users);
		this.jda = jda;
	}

	@Override
	public String getAsMention() {
		return random(users).getAsMention();
	}

	@Override
	public String getId() {
		return random(users).getId();
	}

	@Override
	public String getName() {
		return random(users).getName();
	}

	@Override
	public String getDiscriminator() {
		return random(users).getDiscriminator();
	}

	@Override
	public String getAvatarId() {
		return random(users).getAvatarId();
	}

	@Override
	public String getAvatarUrl() {
		return random(users).getAvatarUrl();
	}

	@Override
	public String getDefaultAvatarId() {
		return random(users).getDefaultAvatarId();
	}

	@Override
	public String getDefaultAvatarUrl() {
		return random(users).getDefaultAvatarUrl();
	}

	@Override
	public String getEffectiveAvatarUrl() {
		return random(users).getEffectiveAvatarUrl();
	}

	@Override
	public boolean hasPrivateChannel() {
		return random(users).isBot();
	}

	@Override
	public RestAction<PrivateChannel> openPrivateChannel() {
		return random(users).openPrivateChannel();
	}

	@Override
	public List<Guild> getMutualGuilds() {
		return random(users).getMutualGuilds();
	}

	@Override
	public PrivateChannel getPrivateChannel() {
		return random(users).getPrivateChannel();
	}

	@Override
	public boolean isBot() {
		return random(users).isBot();
	}

	@Override
	public JDA getJDA() {
		return jda;
	}

	@Override
	public boolean isFake() {
		return random(users).isFake();
	}
}
