package me.kazoku.artxe.bukkit.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple Command builder with command executor, tab completer and more
 */
public class CommandBuilder {

  private final String name;
  private final List<String> aliases = new ArrayList<>();
  private String description;
  private String usage;
  private CommandExecutor executor;
  private TabCompleter tabCompleter;
  private String permission;
  private String permissionMessage;

  private CommandBuilder(@NotNull final String name) {
    this.name = name;
  }

  /**
   * Create a new command builder
   *
   * @param name the command name
   * @return the command builder
   */
  @NotNull
  public static CommandBuilder newCommand(@NotNull final String name) {
    return new CommandBuilder(name);
  }

  /**
   * Build the final Command
   *
   * @return the final Command
   */
  @NotNull
  public Command build() {
    Command command = new Command(name) {
      @Override
      public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        return executor.onCommand(sender, this, commandLabel, args);
      }

      @Override
      public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        return tabCompleter != null
            ? tabCompleter.onTabComplete(sender, this, alias, args)
            : super.tabComplete(sender, alias, args);
      }
    };

    command.setAliases(aliases);
    command.setDescription(description);
    command.setUsage(usage);
    command.setPermission(permission);
    command.setPermissionMessage(permissionMessage);
    return command;
  }

  /**
   * Set the description
   *
   * @param description the description
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setDescription(@Nullable final String description) {
    this.description = description;
    return this;
  }

  /**
   * Set the usage
   *
   * @param usage the usage
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setUsage(@Nullable final String usage) {
    this.usage = usage;
    return this;
  }

  /**
   * Set the command executor
   *
   * @param executor the executor
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setExecutor(@NotNull final CommandExecutor executor) {
    this.executor = executor;
    return this;
  }

  /**
   * Set the tab completer
   *
   * @param tabCompleter the tab completer
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setTabCompleter(@Nullable final TabCompleter tabCompleter) {
    this.tabCompleter = tabCompleter;
    return this;
  }

  /**
   * Set the permission of the command
   *
   * @param permission the permission
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setPermission(@Nullable final String permission) {
    this.permission = permission;
    return this;
  }

  /**
   * Set the message when the sender doesn't have the permission
   *
   * @param permissionMessage the message
   * @return the command builder
   */
  @NotNull
  public CommandBuilder setPermissionMessage(@Nullable final String permissionMessage) {
    this.permissionMessage = permissionMessage;
    return this;
  }

}
