package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class UpdateUserTyping extends TLUpdate {

    public static final int ID = 0x5c486927;

    public int user_id;
    public TLSendMessageAction action;

    public UpdateUserTyping() {
    }

    public UpdateUserTyping(int user_id, TLSendMessageAction action) {
        this.user_id = user_id;
        this.action = action;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        user_id = buffer.readInt();
        action = (TLSendMessageAction) buffer.readTLObject(APIContext.getInstance());
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
        buff.writeInt(user_id);
        buff.writeTLObject(action);
    }


    public int getConstructor() {
        return ID;
    }
}