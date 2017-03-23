# spring-integration-samples

## General concepts

### Messages

A message is a unit of information that can be passed between different components, called message endpoints.

Each message contains of headers and payload. The header contains data that's relevant to the messaging system.
The payload contains the actual data to be accessed or processed by the receiver.

![message](img/message.jpg)

### Message channels

The message channel is the connection between multiple endpoints. The channel implementation manages the details of how and where a message is delivered but shouldn't need to interact with the payload of a message.
Most important characteristic of any channel is that it logically decouples producers from consumers.

Channels may be classified to a single endpoint(point-to-point) or publish-subscribe.

Channels can be categorized based on two dimensions:
type of handoff(synchronous and asynchronous), type of delivery(point-to-point and publish-subscribe)

![point-to-point](img/point-to-point.jpg)

![publish-subscribe](img/publish-subscribe.jpg)

### Message endpoints

Message endpoints are the components that actually do something with the message.
This can be routing, splitting whatever.

Message endpoints basically provide the connections between functional services and the messaging framework.

#### Channel adapter

A _Channel Adapter_ connects an application to the messaging system. Usually channel adapter is placed at the beginning and the end of unidirectional flow.

![channel-adapter](img/channel-adapter.jpg)

#### Messaging gateway

_Messaging gateway_ is a connection that's specific to bidirectional messaging. If an incoming request needs to be services by multiple threads but the invoker to remain unaware of the messaging system, an inbound gateway provides the solution.
On the outbound side, an incoming message can be used in a synchronous invocation, and the result is sent on the reply channel.

![gateway](img/gateway.jpg)
