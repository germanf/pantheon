package net.consensys.pantheon.ethereum.vm;

import net.consensys.pantheon.ethereum.core.Address;
import net.consensys.pantheon.ethereum.core.Log;
import net.consensys.pantheon.ethereum.core.LogTopic;
import net.consensys.pantheon.util.bytes.BytesValue;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogMock extends Log {

  /**
   * Represents a mock log object for testing. Populated from json data.
   *
   * @param address The address of the account generating the log.
   * @param data The data associated with the log.
   * @param topics The topics associated with the log.
   */
  @JsonCreator
  public LogMock(
      @JsonProperty("address") final String address,
      @JsonProperty("data") final String data,
      @JsonProperty("topics") final String[] topics) {
    super(
        Address.fromHexString(address),
        BytesValue.fromHexString(data),
        Arrays.stream(topics)
            .map(s -> LogTopic.wrap(BytesValue.fromHexString(s)))
            .collect(Collectors.toList()));
  }
}