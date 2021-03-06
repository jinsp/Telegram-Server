/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.photos;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;

public class GetUserPhotos extends TLObject {

    public static final int ID = -1209117380;

    public TLInputUser user_id;
    public int offset;
    public int max_id;
    public int limit;

    public GetUserPhotos() {
    }

    public GetUserPhotos(TLInputUser user_id, int offset, int max_id, int limit){
        this.user_id = user_id;
        this.offset = offset;
        this.max_id = max_id;
        this.limit = limit;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        user_id = (TLInputUser) buffer.readTLObject(APIContext.getInstance());
        offset = buffer.readInt();
        max_id = buffer.readInt();
        limit = buffer.readInt();
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
        buff.writeTLObject(user_id);
        buff.writeInt(offset);
        buff.writeInt(max_id);
        buff.writeInt(limit);
    }

    public int getConstructor() {
        return ID;
    }
}