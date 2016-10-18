package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class ReceivedNotifyMessage extends TLReceivedNotifyMessage {

    public static final int ID = 0xa384b779;

    public int id;
    public int flags;

    public ReceivedNotifyMessage() {
    }

    public ReceivedNotifyMessage(int id, int flags) {
        this.id = id;
        this.flags = flags;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readInt();
        flags = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(id);
        buff.writeInt(flags);
    }


    public int getConstructor() {
        return ID;
    }
}