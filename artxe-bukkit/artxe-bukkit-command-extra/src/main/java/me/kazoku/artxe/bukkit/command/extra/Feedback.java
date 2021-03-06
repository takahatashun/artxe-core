package me.kazoku.artxe.bukkit.command.extra;

import org.bukkit.command.CommandSender;

import java.util.function.Supplier;

public class Feedback implements Cloneable {
  private Supplier<String> feedbackSupplier;

  public Feedback(Supplier<String> feedbackSupplier) {
    setFeedback(feedbackSupplier);
  }

  public Feedback(String feedbackString) {
    setFeedback(feedbackString);
  }

  public String getFeedback() {
    return feedbackSupplier.get();
  }

  /**
   * Set the feedback
   *
   * @param feedbackSupplier the feedback
   */
  public void setFeedback(Supplier<String> feedbackSupplier) {
    this.feedbackSupplier = feedbackSupplier;
  }

  /**
   * Set the feedback
   *
   * @param feedback the feedback
   */
  public void setFeedback(String feedback) {
    setFeedback(() -> feedback);
  }

  public void send(CommandSender sender) {
    String feedbackText = getFeedback();
    if (!feedbackText.isEmpty()) sender.sendMessage(feedbackText);
  }
}
